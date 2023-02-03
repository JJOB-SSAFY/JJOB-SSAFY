package com.ssafy.project.db.entity;

import com.ssafy.project.api.request.CompanyRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String companyName;

    @Column(nullable = false)
    private String companyUrl;

    @Column(nullable = false)
    private String companyAddress;

    @Column(nullable = false)
    private int employeeCnt;

    @Column(nullable = false)
    private String companyDesc;

    public static Company from(CompanyRequestDto requestDto) {
        return Company.builder()
                .companyName(requestDto.getCompanyName())
                .companyUrl(requestDto.getCompanyUrl())
                .companyAddress(requestDto.getCompanyAddress())
                .employeeCnt(requestDto.getEmployeeCnt())
                .companyDesc(requestDto.getCompanyDesc())
                .build();
    }

    public void updateCompany(CompanyRequestDto companyRequestDto){
        this.companyName = companyRequestDto.getCompanyName();
        this.companyUrl = companyRequestDto.getCompanyUrl();
        this.companyAddress = companyRequestDto.getCompanyAddress();
        this.employeeCnt = companyRequestDto.getEmployeeCnt();
        this.companyDesc = companyRequestDto.getCompanyDesc();
    }

}
