package com.ssafy.project.api.service;

import com.ssafy.project.api.request.RecruitRequestDto;
import com.ssafy.project.api.request.RecruitSearchCondition;
import com.ssafy.project.api.response.MainResponseDto;
import com.ssafy.project.api.response.RecruitResponseDto;
import com.ssafy.project.api.response.RecruitResponseListDto;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.db.entity.Company;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.entity.Recruit;
import com.ssafy.project.db.repository.CompanyRepository;
import com.ssafy.project.db.repository.MemberRepository;
import com.ssafy.project.db.repository.RecruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecruitServiceImpl implements RecruitService {

    private final RecruitRepository recruitRepository;

    private final CompanyRepository companyRepository;

    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MainResponseDto> getRecruitOrderByDate() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        List<Recruit> recruitList = recruitRepository.findAllByOrderByRecruitEndDateDesc(pageRequest);
        return recruitList.stream().map(MainResponseDto::new).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void createRecruit(Long companyId, RecruitRequestDto requestDto, Long memberId) {
        Optional<Company> findCompany = companyRepository.findById(companyId);

        if (!findCompany.isPresent()) throw new ApiException(ExceptionEnum.COMPANY_NOT_EXIST_EXCEPTION);

        Optional<Member> findMember = memberRepository.findById(memberId);

        if (!findMember.isPresent()) throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);

        Recruit recruit = Recruit.of(requestDto, findCompany.get(), findMember.get());

        recruitRepository.save(recruit);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecruitResponseListDto> getReviewList(RecruitSearchCondition condition) {
        return recruitRepository.getRecruitByLocationAndDepartment(condition);
    }

    @Override
    @Transactional(readOnly = true)
    public RecruitResponseDto getRecruitDetail(Long recruitId) {
        Optional<Recruit> findRecruit = recruitRepository.findById(recruitId);

        if (!findRecruit.isPresent()) throw new ApiException(ExceptionEnum.RECRUIT_NOT_EXIST_EXCEPTION);

        return RecruitResponseDto.of(findRecruit.get());
    }

    @Override
    @Transactional
    public void updateRecruit(Long memberId, Long recruitId, RecruitRequestDto requestDto) {
        Optional<Recruit> findRecruit = recruitRepository.findById(recruitId);

        if (!findRecruit.isPresent()) throw new ApiException(ExceptionEnum.RECRUIT_NOT_EXIST_EXCEPTION);

        if (!findRecruit.get().getMember().getId().equals(memberId)) throw new ApiException(ExceptionEnum.MEMBER_ACCESS_EXCEPTION);

        findRecruit.get().updateRecruit(requestDto);
    }

    @Override
    @Transactional
    public void deleteRecruit(Long memberId, Long recruitId) {
        Optional<Recruit> findRecruit = recruitRepository.findById(recruitId);

        if (!findRecruit.isPresent()) throw new ApiException(ExceptionEnum.RECRUIT_NOT_EXIST_EXCEPTION);

        if (!findRecruit.get().getMember().getId().equals(memberId)) throw new ApiException(ExceptionEnum.MEMBER_ACCESS_EXCEPTION);

        recruitRepository.deleteById(recruitId);
    }

}
