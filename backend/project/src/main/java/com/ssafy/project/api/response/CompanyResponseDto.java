package com.ssafy.project.api.response;

import com.ssafy.project.db.entity.Company;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyResponseDto {
    private String companyName;

    private String companyUrl;

    private String companyAddress;

    private int employeeCnt;

    private String companyDesc;

    private String companyLogo;

    public CompanyResponseDto(Company company) {
        this.companyName=company.getCompanyName();
        this.companyUrl=company.getCompanyUrl();
        this.companyAddress=company.getCompanyAddress();
        this.employeeCnt=company.getEmployeeCnt();
        this.companyDesc=company.getCompanyDesc();
        this.companyLogo=company.getCompanyLogo();
    }


    public static CompanyResponseDto from(Company dto){
        return CompanyResponseDto.builder()
                .companyAddress(dto.getCompanyAddress())
                .companyName(dto.getCompanyName())
                .companyUrl(dto.getCompanyUrl())
                .employeeCnt(dto.getEmployeeCnt())
                .companyDesc(dto.getCompanyDesc())
                .companyLogo(dto.getCompanyLogo())
                .build();
    }


}
