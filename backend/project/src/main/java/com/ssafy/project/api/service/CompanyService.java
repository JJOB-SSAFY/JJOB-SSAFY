package com.ssafy.project.api.service;

import com.ssafy.project.api.request.CompanyRequestDto;
import com.ssafy.project.api.response.CompanyResponseDto;

import java.util.List;

public interface CompanyService {

    void createCompany(CompanyRequestDto requestDto);
    CompanyResponseDto updateCompany(Long company_id, CompanyRequestDto companyRequestDto);
    void deleteCompany(Long company_id);

    List<CompanyResponseDto> getCompany();
}
