package com.ssafy.project.api.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class RecruitResponseListDto {

    private Long recruitId;

    private String recruitTitle;

    private String department;

    private String workType;

    private String work;

    private String requirement;

    private LocalDate recruitEndDate;
    private String companyName;

    @QueryProjection
    public RecruitResponseListDto(Long recruitId, String recruitTitle, String department, String workType,
                                  String work, String requirement, LocalDate recruitEndDate, String companyName) {
        this.recruitId = recruitId;
        this.recruitTitle = recruitTitle;
        this.department = department;
        this.workType = workType;
        this.work = work;
        this.requirement = requirement;
        this.recruitEndDate = recruitEndDate;
        this.companyName = companyName;
    }
}
