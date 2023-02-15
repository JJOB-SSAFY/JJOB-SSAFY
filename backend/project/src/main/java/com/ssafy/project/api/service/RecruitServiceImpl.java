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
import com.ssafy.project.db.repository.ApplyStatusRepository;
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

@Service("recruitService")
@RequiredArgsConstructor
public class RecruitServiceImpl implements RecruitService {

    private final RecruitRepository recruitRepository;

    private final CompanyRepository companyRepository;

    private final MemberRepository memberRepository;

    private final ApplyStatusRepository applyStatusRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MainResponseDto> getRecruitOrderByEndDate() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        List<Recruit> recruitList = recruitRepository.findAllByOrderByRecruitEndDateDesc(pageRequest);
        return recruitList.stream().map(MainResponseDto::new).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MainResponseDto> getRecruitOrderByStartDate() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        List<Recruit> recruitList = recruitRepository.findAllByOrderByRecruitStartDate(pageRequest);
        return recruitList.stream().map(MainResponseDto::new).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void createRecruit(Long companyId, RecruitRequestDto requestDto, Long memberId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ApiException(ExceptionEnum.COMPANY_NOT_EXIST_EXCEPTION));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION));

        Recruit recruit = Recruit.of(requestDto, company, member);

        recruitRepository.save(recruit);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecruitResponseListDto> getRecruitList(RecruitSearchCondition condition) {
        return recruitRepository.getRecruitByLocationAndDepartment(condition);
    }

    @Override
    @Transactional(readOnly = true)
    public RecruitResponseDto getRecruitDetail(Long recruitId) {
        Recruit recruit = recruitRepository.findById(recruitId)
                .orElseThrow(() -> new ApiException(ExceptionEnum.RECRUIT_NOT_EXIST_EXCEPTION));

        return RecruitResponseDto.of(recruit);
    }

    @Override
    @Transactional
    public void updateRecruit(Long memberId, Long recruitId, RecruitRequestDto requestDto) {
        Recruit recruit = recruitRepository.findById(recruitId)
                .orElseThrow(() -> new ApiException(ExceptionEnum.RECRUIT_NOT_EXIST_EXCEPTION));

        if (!recruit.getMember().getId().equals(memberId)) throw new ApiException(ExceptionEnum.MEMBER_ACCESS_EXCEPTION);

        recruit.updateRecruit(requestDto);
    }

    @Override
    @Transactional
    public void deleteRecruit(Long memberId, Long recruitId) {
        Recruit recruit = recruitRepository.findById(recruitId)
                .orElseThrow(() -> new ApiException(ExceptionEnum.RECRUIT_NOT_EXIST_EXCEPTION));

        if (!recruit.getMember().getId().equals(memberId)) throw new ApiException(ExceptionEnum.MEMBER_ACCESS_EXCEPTION);

        applyStatusRepository.deleteAllByRecruitId(recruitId);

        recruitRepository.deleteById(recruitId);
    }

}
