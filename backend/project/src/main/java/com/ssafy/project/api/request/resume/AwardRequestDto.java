package com.ssafy.project.api.request.resume;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AwardRequestDto {

    private String awardName;

    private String awardDate;

    private String awardInstitution;
}
