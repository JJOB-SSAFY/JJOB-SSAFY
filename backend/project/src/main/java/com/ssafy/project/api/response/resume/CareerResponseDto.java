package com.ssafy.project.api.response.resume;

import com.ssafy.project.db.entity.resume.Career;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CareerResponseDto {

    private String companyName;

    private String careerPeriod;

    private String careerContent;

    public CareerResponseDto(Career career) {
        this.companyName = career.getCompanyName();
        this.careerPeriod = career.getCareerPeriod();
        this.careerContent = career.getCareerContent();

    }


}
