package com.ssafy.project.api.service;

import com.ssafy.project.api.request.resume.*;
import com.ssafy.project.api.response.resume.*;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.db.entity.ApplyStatus;
import com.ssafy.project.db.entity.Card;
import com.ssafy.project.db.entity.Company;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.entity.resume.*;
import com.ssafy.project.db.repository.ApplyStatusRepository;
import com.ssafy.project.db.repository.CardRepository;
import com.ssafy.project.db.repository.CompanyRepository;
import com.ssafy.project.db.repository.MemberRepository;
import com.ssafy.project.db.repository.resume.*;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.Opt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service("resumeService")
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;
    private final MemberRepository memberRepository;
    private final ActivityRepository activityRepository;
    private final AwardRepository awardRepository;
    private final CareerRepository careerRepository;
    private final CertificateRepository certificateRepository;
    private final CoverLetterRepository coverLetterRepository;
    private final EducationRepository educationRepository;
    private final LanguageAbilityRepository languageAbilityRepository;
    private final ProjectExpRepository projectExpRepository;
    private final SkillRepository skillRepository;
    private final UniversityRepository universityRepository;
    private final CardRepository cardRepository;

    private final ApplyStatusRepository applyStatusRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ResumeListResponseDto> getResumeList(Long memberId) {
        List<Resume> list = resumeRepository.findAllByMemberId(memberId);

        return list.stream().map(ResumeListResponseDto::new).collect(toList());
    }

    @Override
    @Transactional
    public void createResume(ResumeRequestDto requestDto, Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);

        if(member.isEmpty()) throw new ApiException(ExceptionEnum.MEMBER_EXIST_EXCEPTION);


        //넣어야하는 resume 엔티티와 연결되어 있는 모든 엔티티를 생성해준다.
        Resume resume = Resume.of(member.get(), requestDto);
        resumeRepository.save(resume);

        //activity entity
        List<ActivityRequestDto> activityDtoList = requestDto.getActivityDtoList();
        List<Activity> activityList = activityDtoList.stream().map((o) -> new Activity(resume, o)).collect(toList());
        activityRepository.saveAll(activityList);


        //award
        List<AwardRequestDto> awardRequestDtoList = requestDto.getAwardDtoList();
        List<Award> awardList = awardRequestDtoList.stream().map((o) -> new Award(resume, o)).collect(toList());
        awardRepository.saveAll(awardList);

        //career
        List<CareerRequestDto> careerRequestDtoList = requestDto.getCareerDtoList();
        List<Career> careerList = careerRequestDtoList.stream().map((o)-> new Career(resume, o)).collect(toList());
        careerRepository.saveAll(careerList);


        //certificate
        List<CertificateRequestDto> certificateRequestDtoList = requestDto.getCertificateDtoList();
        List<Certificate> certificateList = certificateRequestDtoList.stream().map((o)-> new Certificate(resume, o)).collect(toList());
        certificateRepository.saveAll(certificateList);

        //coverLetter
        List<CoverLetterRequestDto> coverLetterRequestDtoList = requestDto.getCoverLetterDtoList();
        List<CoverLetter> coverLetterList = coverLetterRequestDtoList.stream().map((o)-> new CoverLetter(resume, o)).collect(toList());
        coverLetterRepository.saveAll(coverLetterList);


        //education
        List<EducationRequestDto> educationRequestDtoList = requestDto.getEducationDtoList();
        List<Education> educationList = educationRequestDtoList.stream().map((o)-> new Education(resume, o)).collect(toList());
        educationRepository.saveAll(educationList);


        //languageAbility
        List<LanguageAbilityRequestDto> languageAbilityRequestDtoList = requestDto.getLanguageAbilityDtoList();
        List<LanguageAbility> languageAbilityList = languageAbilityRequestDtoList.stream().map((o)-> new LanguageAbility(resume, o)).collect(toList());
        languageAbilityRepository.saveAll(languageAbilityList);


        //projectExp
        List<ProjectExpRequestDto> projectExpRequestDtoList = requestDto.getProjectExpDtoList();
        List<ProjectExp> projectExpList = projectExpRequestDtoList.stream().map((o)-> new ProjectExp(resume, o)).collect(toList());
        projectExpRepository.saveAll(projectExpList);



        //skill
        List<SkillRequestDto> skillRequestDtoList = requestDto.getSkillDtoList();
        List<Skill> skillList = skillRequestDtoList.stream().map((o)-> new Skill(resume, o)).collect(toList());
        skillRepository.saveAll(skillList);

        //University
        List<UniversityRequestDto> universityRequestDtoList = requestDto.getUniversityDtoList();
        List<University> universityList = universityRequestDtoList.stream().map((o)-> new University(resume, o)).collect(toList());
        universityRepository.saveAll(universityList);
    }

    @Override
    @Transactional
    public void updateResume(ResumeRequestDto requestDto, Long resumeId) {

        //resume update
        Optional<Resume> resume = resumeRepository.findById(resumeId);
        if(resume.isEmpty()) throw new ApiException(ExceptionEnum.RESUME_NOT_EXIST_EXCEPTION);

        resume.get().updateResume(requestDto);

        //연관된 테이블들 전부 삭제
        deleteRelatedData(resumeId);

        //수정된 내용대로 테이블들 재생성 및 resume 매핑

        //activity entity
        List<ActivityRequestDto> activityDtoList = requestDto.getActivityDtoList();
        List<Activity> activityList = activityDtoList.stream().map((o) -> new Activity(resume.get(), o)).collect(toList());
        activityRepository.saveAll(activityList);

        //award
        List<AwardRequestDto> awardRequestDtoList = requestDto.getAwardDtoList();
        List<Award> awardList = awardRequestDtoList.stream().map((o) -> new Award(resume.get(), o)).collect(toList());
        awardRepository.saveAll(awardList);

        //career
        List<CareerRequestDto> careerRequestDtoList = requestDto.getCareerDtoList();
        List<Career> careerList = careerRequestDtoList.stream().map((o)-> new Career(resume.get(), o)).collect(toList());
        careerRepository.saveAll(careerList);

        //certificate
        List<CertificateRequestDto> certificateRequestDtoList = requestDto.getCertificateDtoList();
        List<Certificate> certificateList = certificateRequestDtoList.stream().map((o)-> new Certificate(resume.get(), o)).collect(toList());
        certificateRepository.saveAll(certificateList);

        //coverLetter
        List<CoverLetterRequestDto> coverLetterRequestDtoList = requestDto.getCoverLetterDtoList();
        List<CoverLetter> coverLetterList = coverLetterRequestDtoList.stream().map((o)-> new CoverLetter(resume.get(), o)).collect(toList());
        coverLetterRepository.saveAll(coverLetterList);

        //education
        List<EducationRequestDto> educationRequestDtoList = requestDto.getEducationDtoList();
        List<Education> educationList = educationRequestDtoList.stream().map((o)-> new Education(resume.get(), o)).collect(toList());
        educationRepository.saveAll(educationList);

        //languageAbility
        List<LanguageAbilityRequestDto> languageAbilityRequestDtoList = requestDto.getLanguageAbilityDtoList();
        List<LanguageAbility> languageAbilityList = languageAbilityRequestDtoList.stream().map((o)-> new LanguageAbility(resume.get(), o)).collect(toList());
        languageAbilityRepository.saveAll(languageAbilityList);

        //projectExp
        List<ProjectExpRequestDto> projectExpRequestDtoList = requestDto.getProjectExpDtoList();
        List<ProjectExp> projectExpList = projectExpRequestDtoList.stream().map((o)-> new ProjectExp(resume.get(), o)).collect(toList());
        projectExpRepository.saveAll(projectExpList);

        //skill
        List<SkillRequestDto> skillRequestDtoList = requestDto.getSkillDtoList();
        List<Skill> skillList = skillRequestDtoList.stream().map((o)-> new Skill(resume.get(), o)).collect(toList());
        skillRepository.saveAll(skillList);

        //University
        List<UniversityRequestDto> universityRequestDtoList = requestDto.getUniversityDtoList();
        List<University> universityList = universityRequestDtoList.stream().map((o)-> new University(resume.get(), o)).collect(toList());
        universityRepository.saveAll(universityList);

    }


    @Override
    @Transactional
    public void deleteResume(Long resumeId) {
        Optional<Resume> resume = resumeRepository.findById(resumeId);
        if(resume.isEmpty()) throw new ApiException(ExceptionEnum.RESUME_NOT_EXIST_EXCEPTION);

        //연관된 테이블들 전부 삭제
        deleteRelatedData(resumeId);

        //resume 삭제
        resumeRepository.deleteById(resumeId);
    }

    @Override
    @Transactional(readOnly = true)
    public ResumeResponseDto getResume(Long resumeId) {
        Optional<Resume> resume = resumeRepository.findById(resumeId);
        if(resume.isEmpty()) throw new ApiException(ExceptionEnum.RESUME_NOT_EXIST_EXCEPTION);

        //activityDto
        List<Activity> activityList = activityRepository.findAllByResumeId(resumeId);
        List<ActivityResponseDto> activityResponseDtoList = activityList.stream().map(ActivityResponseDto::new).collect(toList());

        //awardDto
        List<Award> awardList = awardRepository.findAllByResumeId(resumeId);
        List<AwardResponseDto> awardResponseDtoList = awardList.stream().map(AwardResponseDto::new).collect(toList());

        //career
        List<Career> careerList = careerRepository.findAllByResumeId(resumeId);
        List<CareerResponseDto> careerResponseDtoList = careerList.stream().map(CareerResponseDto::new).collect(toList());

        //certificate
        List<Certificate> certificateList = certificateRepository.findAllByResumeId(resumeId);
        List<CertificateResponseDto> certificateResponseDtoList = certificateList.stream().map(CertificateResponseDto::new).collect(toList());

        //coverletter
        List<CoverLetter> coverLetterList = coverLetterRepository.findAllByResumeId(resumeId);
        List<CoverLetterResponseDto> coverLetterResponseDtoList = coverLetterList.stream().map(CoverLetterResponseDto::new).collect(toList());

        //education
        List<Education> educationList = educationRepository.findAllByResumeId(resumeId);
        List<EducationResponseDto> educationResponseDtoList = educationList.stream().map(EducationResponseDto::new).collect(toList());

        //languageAbility
        List<LanguageAbility> languageAbilityList = languageAbilityRepository.findAllByResumeId(resumeId);
        List<LanguageAbilityResponseDto> languageAbilityResponseDtoList = languageAbilityList.stream().map(LanguageAbilityResponseDto::new).collect(toList());

        //projectExp
        List<ProjectExp> projectExpList = projectExpRepository.findAllByResumeId(resumeId);
        List<ProjectExpResponseDto> projectExpResponseDtoList = projectExpList.stream().map(ProjectExpResponseDto::new).collect(toList());

        //Skill
        List<Skill> skillList = skillRepository.findAllByResumeId(resumeId);
        List<SkillResponseDto> skillResponseDtoList = skillList.stream().map(SkillResponseDto::new).collect(toList());

        //university
        List<University> universityList = universityRepository.findAllByResumeId(resumeId);
        List<UniversityResponseDto> universityResponseDtoList = universityList.stream().map(UniversityResponseDto::new).collect(toList());

        Optional<Card> card = cardRepository.findById(resume.get().getMember().getCard().getId());

        return ResumeResponseDto.of(resume.get(), activityResponseDtoList,
                awardResponseDtoList, careerResponseDtoList,
                certificateResponseDtoList, coverLetterResponseDtoList,
                educationResponseDtoList, languageAbilityResponseDtoList,
                projectExpResponseDtoList, skillResponseDtoList,
                universityResponseDtoList, card.get().getImageUrl());

    }

    @Override
    @Transactional
    public void changeApplyStatus(Long applyId) {
        Resume resume = resumeRepository.findById(applyId)
                .orElseThrow(() -> new ApiException(ExceptionEnum.RESUME_NOT_EXIST_EXCEPTION));

        resume.updateStatus();

        ApplyStatus applyStatus = applyStatusRepository.findByResumeId(resume.getId())
                .orElseThrow(() -> new ApiException(ExceptionEnum.ApplyStatus_NOT_EXIT_EXCEPTION));

        applyStatus.updateStatus();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResumeListResponseDto> getIsAppliedResumeList(Long memberId) {
        List<Resume> list = resumeRepository.findAllByMemberIdAndIsApplied(memberId, false);

        return list.stream().map(ResumeListResponseDto::new).collect(toList());
    }

    private void deleteRelatedData(Long resumeId) {
        activityRepository.deleteAllByResumeId(resumeId);
        awardRepository.deleteAllByResumeId(resumeId);
        careerRepository.deleteAllByResumeId(resumeId);
        certificateRepository.deleteAllByResumeId(resumeId);
        coverLetterRepository.deleteAllByResumeId(resumeId);
        educationRepository.deleteAllByResumeId(resumeId);
        languageAbilityRepository.deleteAllByResumeId(resumeId);
        projectExpRepository.deleteAllByResumeId(resumeId);
        skillRepository.deleteAllByResumeId(resumeId);
        universityRepository.deleteAllByResumeId(resumeId);
    }

}
