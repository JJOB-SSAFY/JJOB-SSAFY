package com.ssafy.project.api.response.resume;

import com.ssafy.project.db.entity.resume.Education;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EducationResponseDto {

    private String educationName;

    private String educationPeriod;

    private String educationContent;

    private String educationInstitution;

    public EducationResponseDto(Education education){
        this.educationName = education.getEducationName();
        this.educationPeriod = education.getEducationPeriod();
        this.educationContent = education.getEducationContent();
        this.educationInstitution = education.getEducationInstitution();

    }

}
