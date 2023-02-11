package com.ssafy.project.db.entity.resume;

import com.ssafy.project.api.request.resume.ActivityRequestDto;
import com.ssafy.project.api.request.resume.ResumeRequestDto;
import lombok.*;
import org.checkerframework.checker.units.qual.A;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Long id;

    private String activityName;

    private String activityPeriod;

    private String activityContent;

    private String activityInstitution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Activity(Resume resume, ActivityRequestDto requestDto) {
        this.resume = resume;
        this.activityName = requestDto.getActivityName();
        this.activityPeriod = requestDto.getActivityPeriod();
        this.activityInstitution = requestDto.getActivityInstitution();
        this.activityContent = requestDto.getActivityContent();
    }

    public void updateActivity(ActivityRequestDto requestDto){
        this.activityName = requestDto.getActivityName();
        this.activityPeriod = requestDto.getActivityPeriod();
        this.activityInstitution = requestDto.getActivityInstitution();
        this.activityContent = requestDto.getActivityContent();
    }

    public Activity(Activity activity, Resume resume) {
        this.activityName = activity.getActivityName();
        this.activityPeriod = activity.getActivityPeriod();
        this.activityInstitution = activity.getActivityInstitution();
        this.activityContent = activity.getActivityContent();
        this.resume = resume;
    }


}
