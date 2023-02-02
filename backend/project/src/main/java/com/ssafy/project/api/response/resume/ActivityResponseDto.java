package com.ssafy.project.api.response.resume;

import com.ssafy.project.db.entity.resume.Activity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ActivityResponseDto {

    private String activityName;

    private String activityPeriod;

    private String activityContent;

    private String activityInstitution;

    public ActivityResponseDto(Activity activity){
        this.activityName = activity.getActivityName();
        this.activityPeriod = activity.getActivityPeriod();
        this.activityContent = activity.getActivityContent();
        this.activityInstitution = activity.getActivityInstitution();
    }


}
