package com.ssafy.project.api.request.resume;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CareerRequestDto {

    private String companyName;

    private String careerPeriod;

    private String careerContent;

}
