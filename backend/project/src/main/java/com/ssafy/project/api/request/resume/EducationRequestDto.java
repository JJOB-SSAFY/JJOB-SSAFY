package com.ssafy.project.api.request.resume;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EducationRequestDto {

    private String educationName;

    private String educationPeriod;

    private String educationContent;

    private String educationInstitution;

}
