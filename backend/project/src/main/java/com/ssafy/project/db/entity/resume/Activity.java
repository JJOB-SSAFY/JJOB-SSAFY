package com.ssafy.project.db.entity.resume;

import com.ssafy.project.api.request.resume.ActivityRequestDto;
import com.ssafy.project.api.request.resume.ResumeRequestDto;
import lombok.*;

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

    @Column(nullable = false)
    private String activityName;

    @Column(nullable = false)
    private String activityPeriod;

    @Column(nullable = false)
    private String activityContent;

    @Column(nullable = false)
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


}
