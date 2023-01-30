package com.ssafy.project.api.service;

import com.ssafy.project.api.request.RecruitRequestDto;
import com.ssafy.project.api.response.MainResponseDto;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.db.entity.Company;
import com.ssafy.project.db.entity.Recruit;
import com.ssafy.project.db.repository.CompanyRepository;
import com.ssafy.project.db.repository.RecruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecruitServiceImpl implements RecruitService {

    private final RecruitRepository recruitRepository;

    private final CompanyRepository companyRepository;

    @Override
    public List<MainResponseDto> getRecruitOrderByDate() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        List<Recruit> recruitList = recruitRepository.findAllByOrderByRecruitEndDateDesc(pageRequest);
        return recruitList.stream().map(MainResponseDto::new).collect(Collectors.toList());
    }

    @Override
    public void createRecruit(Long companyId, RecruitRequestDto requestDto) {
        Optional<Company> findCompany = companyRepository.findById(companyId);

        if (!findCompany.isPresent()) {
            throw new ApiException(ExceptionEnum.COMPANY_NOT_EXIST_EXCEPTION);
        }

        Recruit recruit = Recruit.of(requestDto, findCompany.get());

        recruitRepository.save(recruit);
    }

}
