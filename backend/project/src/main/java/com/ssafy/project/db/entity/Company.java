package com.ssafy.project.db.entity;

import com.ssafy.project.api.request.CompanyRequestDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@DynamicInsert

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

    @ColumnDefault("'https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2FLogo.png?alt=media&token=6b1c5377-2694-4836-85f6-00b377113391'")
    private String companyLogo;

    public static Company from(CompanyRequestDto requestDto) {
        return Company.builder()
                .companyName(requestDto.getCompanyName())
                .companyUrl(requestDto.getCompanyUrl())
                .companyAddress(requestDto.getCompanyAddress())
                .employeeCnt(requestDto.getEmployeeCnt())
                .companyDesc(requestDto.getCompanyDesc())
                .companyLogo(requestDto.getCompanyLogo())
                .build();
    }

    public void updateCompany(CompanyRequestDto companyRequestDto){
        this.companyName = companyRequestDto.getCompanyName();
        this.companyUrl = companyRequestDto.getCompanyUrl();
        this.companyAddress = companyRequestDto.getCompanyAddress();
        this.employeeCnt = companyRequestDto.getEmployeeCnt();
        this.companyDesc = companyRequestDto.getCompanyDesc();
        this.companyLogo = companyRequestDto.getCompanyLogo();
    }

}
