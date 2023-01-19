package com.ssafy.project.db.entity.resume;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
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

}
