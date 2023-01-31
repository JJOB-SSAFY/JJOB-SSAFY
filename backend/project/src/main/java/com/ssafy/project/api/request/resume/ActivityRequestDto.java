package com.ssafy.project.api.request.resume;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ActivityRequestDto {

    private String activityName;

    private String activityPeriod;

    private String activityContent;

    private String activityInstitution;

}
