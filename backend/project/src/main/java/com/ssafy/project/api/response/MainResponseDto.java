package com.ssafy.project.api.response;

import com.ssafy.project.db.entity.Recruit;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MainResponseDto {

    private String companyName;

    private String recruitTitle;

    private LocalDate recruitStartDate;

    private LocalDate recruitEndDate;

    public MainResponseDto(Recruit recruit) {
        this.companyName = recruit.getCompany().getCompanyName();
        this.recruitTitle = recruit.getRecruitTitle();
        this.recruitStartDate = recruit.getRecruitStartDate();
        this.recruitEndDate = recruit.getRecruitEndDate();
    }
}
