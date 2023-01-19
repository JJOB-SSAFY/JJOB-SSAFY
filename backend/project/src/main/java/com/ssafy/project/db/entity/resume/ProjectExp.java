package com.ssafy.project.db.entity.resume;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class ProjectExp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column(nullable = false)
    private String projectName;

    @Column(nullable = false)
    private String projectPeriod;

    @Column(nullable = false)
    private String memberCnt;

    @Column(nullable = false)
    private String summary;

    @Column(nullable = false)
    private String techEnv;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String function;

    @Column(nullable = false)
    private String result;

    @Column(nullable = false)
    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

}
