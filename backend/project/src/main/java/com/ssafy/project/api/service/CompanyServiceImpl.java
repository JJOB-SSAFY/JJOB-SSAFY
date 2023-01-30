package com.ssafy.project.api.service;

import com.ssafy.project.api.request.CompanyRequestDto;
import com.ssafy.project.db.entity.Company;
import com.ssafy.project.db.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
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
}
