package com.ssafy.project.api.response;

import com.ssafy.project.db.entity.Recruit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitResponseDto {

    private String companyName;

    private String recruitTitle;

    private String eduRequirement;

    private String salary;

    private String workType;

    private String work;

    private String location;

    private String career;

    private String department;

    private String imgUrl;
    private String recruitContent;

    public static RecruitResponseDto of(Recruit recruit) {
        return RecruitResponseDto.builder()
                .companyName(recruit.getCompany().getCompanyName())
                .recruitTitle(recruit.getRecruitTitle())
                .eduRequirement(recruit.getEduRequirement())
                .salary(recruit.getSalary())
                .workType(recruit.getWorkType())
                .work(recruit.getWork())
                .location(recruit.getLocation())
                .career(recruit.getCareer())
                .department(recruit.getDepartment())
                .imgUrl(recruit.getImgUrl())
                .recruitContent(recruit.getRecruitContent())
                .build();
    }

}
