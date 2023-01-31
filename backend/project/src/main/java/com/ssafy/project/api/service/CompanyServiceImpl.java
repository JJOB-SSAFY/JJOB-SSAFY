package com.ssafy.project.api.service;

import com.ssafy.project.api.request.CompanyRequestDto;
import com.ssafy.project.api.response.CompanyResponseDto;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.db.entity.Company;
import com.ssafy.project.db.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    @Transactional
    public void createCompany(CompanyRequestDto requestDto) {
        Company company = Company.builder()
                .companyName(requestDto.getCompanyName())
                .companyUrl(requestDto.getCompanyUrl())
                .companyAddress(requestDto.getCompanyAddress())
                .employeeCnt(requestDto.getEmployeeCnt())
                .companyDesc(requestDto.getCompanyDesc())
                .build();

        companyRepository.save(company);
    }

    @Override
    @Transactional
    public CompanyResponseDto updateCompany(Long companyId, CompanyRequestDto requestDto){
        Optional<Company> company = companyRepository.findById(companyId);
        if(!company.isPresent())    throw new ApiException(ExceptionEnum.COMPANY_NOT_EXIST_EXCEPTION);
//        log.info(""+requestDto.getEmployeeCnt());
        log.info("////////////////////");
        company.get().updateCompany(requestDto);
        CompanyResponseDto dto = CompanyResponseDto.of(company.get());
        return dto;
    }

    @Override
    @Transactional
    public void deleteCompany(Long companyId){
        Optional<Company> company = companyRepository.findById(companyId);
        if(!company.isPresent()) throw new ApiException(ExceptionEnum.COMPANY_NOT_EXIST_EXCEPTION);
        companyRepository.delete(company.get());
    }

    // @Override
    //    @Transactional
    //    public void deleteReview(Long reviewId) {
    //        Optional<Review> review = reviewRepository.findById(reviewId);
    //        if(!review.isPresent()) throw new ApiException(ExceptionEnum.REVIEW_NOT_EXIST_EXCEPTION);
    //        reviewRepository.delete(review.get());
    //    }

}
