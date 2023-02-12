package com.ssafy.project.api.service;

import com.ssafy.project.api.request.ApplyRequestDto;
import com.ssafy.project.api.response.ApplyCompRes;
import com.ssafy.project.api.response.ApplyStatusRes;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.db.entity.ApplyStatus;
import com.ssafy.project.db.entity.Company;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.entity.Recruit;
import com.ssafy.project.db.entity.resume.*;
import com.ssafy.project.db.repository.ApplyStatusRepository;
import com.ssafy.project.db.repository.CompanyRepository;
import com.ssafy.project.db.repository.MemberRepository;
import com.ssafy.project.db.repository.RecruitRepository;
import com.ssafy.project.db.repository.resume.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("applyService")
@RequiredArgsConstructor
@Slf4j
public class ApplyServiceImpl implements ApplyService {

    private final ApplyStatusRepository applyStatusRepository;
    private final ResumeRepository resumeRepository;
    private final MemberRepository memberRepository;
    private final CompanyRepository companyRepository;
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

    private final RecruitRepository recruitRepository;

    @Override
    @Transactional
    public void createApply(Long recruitId, Long resumeId, Long memberId, ApplyRequestDto requestDto) {

        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Recruit> recruit = recruitRepository.findById(recruitId);
        Optional<Resume> resume = resumeRepository.findById(resumeId);


        if(member.isEmpty()) throw new ApiException(ExceptionEnum.MEMBER_EXIST_EXCEPTION);
        if(recruit.isEmpty()) throw new ApiException(ExceptionEnum.RECRUIT_NOT_EXIST_EXCEPTION);
        if(resume.isEmpty()) throw new ApiException(ExceptionEnum.RESUME_NOT_EXIST_EXCEPTION);

        //resume 엔티티 복사 및 그와 연관된 테이블 엔티티들도 전부 복사해준다.
        //그리고 복사된 resume의 isApplied에 트루 설정
        Resume cpResume = new Resume(resume.get()); //생성자에서 isApplied에 트루 설정
        resumeRepository.save(cpResume);

        //Activity
        List<Activity> activityList = activityRepository.findAllByResumeId(resume.get().getId());
        List<Activity> cpActivityList = activityList.stream().map((o)-> new Activity(o, cpResume)).collect(Collectors.toList());
        activityRepository.saveAll(cpActivityList);

        //Award
        List<Award> awardList = awardRepository.findAllByResumeId(resume.get().getId());
        List<Award> cpAwardList = awardList.stream().map((o)-> new Award(o, cpResume)).collect(Collectors.toList());
        awardRepository.saveAll(cpAwardList);

        //Career
        List<Career> careerList = careerRepository.findAllByResumeId(resume.get().getId());
        List<Career> cpCareerList = careerList.stream().map((o)-> new Career(o, cpResume)).collect(Collectors.toList());
        careerRepository.saveAll(cpCareerList);

        //Certificate
        List<Certificate> certificateList = certificateRepository.findAllByResumeId(resume.get().getId());
        List<Certificate> cpCertificateList = certificateList.stream().map((o)-> new Certificate(o, cpResume)).collect(Collectors.toList());
        certificateRepository.saveAll(cpCertificateList);

        //CoverLetter
        List<CoverLetter> coverLetterList = coverLetterRepository.findAllByResumeId(resume.get().getId());
        List<CoverLetter> cpCoverLetterList = coverLetterList.stream().map((o)-> new CoverLetter(o, cpResume)).collect(Collectors.toList());
        coverLetterRepository.saveAll(cpCoverLetterList);

        //Education
        List<Education> educationList = educationRepository.findAllByResumeId(resume.get().getId());
        List<Education> cpEducationList = educationList.stream().map((o)-> new Education(o, cpResume)).collect(Collectors.toList());
        educationRepository.saveAll(cpEducationList);

        //Language
        List<LanguageAbility> languageAbilityList = languageAbilityRepository.findAllByResumeId(resume.get().getId());
        List<LanguageAbility> cpLanguageAbilityList = languageAbilityList.stream().map((o)-> new LanguageAbility(o, cpResume)).collect(Collectors.toList());
        languageAbilityRepository.saveAll(cpLanguageAbilityList);

        //Project
        List<ProjectExp> projectExpList = projectExpRepository.findAllByResumeId(resume.get().getId());
        List<ProjectExp> cpProjectExpList = projectExpList.stream().map((o)-> new ProjectExp(o, cpResume)).collect(Collectors.toList());
        projectExpRepository.saveAll(cpProjectExpList);



        //Skill
        List<Skill> skillList = skillRepository.findAllByResumeId(resume.get().getId());
        List<Skill> cpSkillList = skillList.stream().map((o)-> new Skill(o, cpResume)).collect(Collectors.toList());
        skillRepository.saveAll(cpSkillList);

        //University
        List<University> universityList = universityRepository.findAllByResumeId(resume.get().getId());
        List<University> cpUniversityList = universityList.stream().map((o)-> new University(o, cpResume)).collect(Collectors.toList());
        universityRepository.saveAll(cpUniversityList);

        //복사된 resume의 아이디를 넣어줘서 apply entity를 만들어준다.
        ApplyStatus apply = ApplyStatus.of(member.get(), recruit.get(), requestDto, cpResume);
        applyStatusRepository.save(apply);

    }

    @Override
    @Transactional
    public void updateApplyStatus(Long applyId,ApplyRequestDto requestDto) {
        Optional<ApplyStatus> applyStatus = applyStatusRepository.findById(applyId);
        if(applyStatus.isEmpty()) throw  new ApiException(ExceptionEnum.ApplyStatus_NOT_EXIT_EXCEPTION);

        applyStatus.get().updateApplyStatus(requestDto);


    }

    @Override
    @Transactional
    public void deleteApplyStatus(Long applyId) {
        Optional<ApplyStatus> applyStatus = applyStatusRepository.findById(applyId);
        if(applyStatus.isEmpty()) throw  new ApiException(ExceptionEnum.ApplyStatus_NOT_EXIT_EXCEPTION);

        //연관된 자소서 가져오고 삭제해준다
        Optional<Resume> resume = resumeRepository.findById(applyStatus.get().getResume().getId());

        //자소서와 관련된 연관 객체들도 전부 삭제해준다.
        deleteRelatedData(applyStatus.get().getResume().getId());
        resumeRepository.deleteById(applyStatus.get().getResume().getId());

        applyStatusRepository.deleteById(applyId);

    }

    @Override
    @Transactional(readOnly = true)
    public List<ApplyCompRes> getApplyList(Long companyId) {
        Optional<Company> company = companyRepository.findById(companyId);
        if(company.isEmpty()) throw new ApiException(ExceptionEnum.COMPANY_NOT_EXIST_EXCEPTION);

        List<Recruit> recruitList = recruitRepository.findAllByCompanyId(companyId);
        List<ApplyStatus> joinedList = null;
        if(recruitList.size()!=0){
            joinedList = applyStatusRepository.findAllByRecruitId(recruitList.get(0).getId());
        }
        if(recruitList.size()>1){
            for(int i=1; i< recruitList.size(); i++){
                List<ApplyStatus> list = applyStatusRepository.findAllByRecruitId(recruitList.get(i).getId());
                joinedList.addAll(list);
            }
        }


        return joinedList.stream().map((o)-> new ApplyCompRes(o)).collect(Collectors.toList());

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
