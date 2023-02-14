package com.ssafy.project.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequestDto {

    private String companyName;

    private String companyUrl;

    private String companyAddress;

    private int employeeCnt;

    private String companyDesc;

    private String companyLogo;
}
