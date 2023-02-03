package com.ssafy.project.api.service;

import com.ssafy.project.api.request.CompanyRequestDto;
import com.ssafy.project.api.response.CompanyResponseDto;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.db.entity.Company;
import com.ssafy.project.db.repository.CompanyRepository;
import com.ssafy.project.db.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("companyService")
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public void createCompany(CompanyRequestDto requestDto) {
        Company company = Company.from(requestDto);
        companyRepository.save(company);
    }

    @Override
    @Transactional
    public CompanyResponseDto updateCompany(Long companyId, CompanyRequestDto requestDto){
        Optional<Company> company = companyRepository.findById(companyId);

        if(company.isEmpty()) throw new ApiException(ExceptionEnum.COMPANY_NOT_EXIST_EXCEPTION);

        company.get().updateCompany(requestDto);

        return CompanyResponseDto.from(company.get());
    }

    @Override
    @Transactional
    public void deleteCompany(Long companyId){
        Optional<Company> company = companyRepository.findById(companyId);
        if(company.isEmpty()) throw new ApiException(ExceptionEnum.COMPANY_NOT_EXIST_EXCEPTION);
        reviewRepository.deleteAllByCompanyId(companyId);
        companyRepository.delete(company.get());
    }

}
