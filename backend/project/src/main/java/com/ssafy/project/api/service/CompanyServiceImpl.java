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

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ApiException(ExceptionEnum.COMPANY_NOT_EXIST_EXCEPTION));

        company.updateCompany(requestDto);

        return CompanyResponseDto.from(company);
    }

    @Override
    @Transactional
    public void deleteCompany(Long companyId){
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ApiException(ExceptionEnum.COMPANY_NOT_EXIST_EXCEPTION));
        reviewRepository.deleteAllByCompanyId(companyId);
        companyRepository.delete(company);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyResponseDto> getCompany() {
        List<Company> companyList = companyRepository.findAll();
        return companyList.stream().map(CompanyResponseDto::new).collect(Collectors.toList());
    }

}
