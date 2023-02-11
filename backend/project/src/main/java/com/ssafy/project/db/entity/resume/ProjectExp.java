package com.ssafy.project.db.entity.resume;

import com.ssafy.project.api.request.resume.ProjectExpRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
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

    public ProjectExp(Resume resume, ProjectExpRequestDto requestDto){
        this.resume = resume;
        this.projectName = requestDto.getProjectName();
        this.projectPeriod = requestDto.getProjectPeriod();
        this.memberCnt = requestDto.getMemberCnt();
        this.summary = requestDto.getSummary();
        this.techEnv = requestDto.getTechEnv();
        this.position = requestDto.getPosition();
        this.function = requestDto.getFunction();
        this.result = requestDto.getResult();
        this.link = requestDto.getLink();
    }

    public void updateProjectExp(ProjectExpRequestDto requestDto) {
        this.projectName = requestDto.getProjectName();
        this.projectPeriod = requestDto.getProjectPeriod();
        this.memberCnt = requestDto.getMemberCnt();
        this.summary = requestDto.getSummary();
        this.techEnv = requestDto.getTechEnv();
        this.position = requestDto.getPosition();
        this.function = requestDto.getFunction();
        this.result = requestDto.getResult();
        this.link = requestDto.getLink();
    }

    public ProjectExp(ProjectExp projectExp, Resume resume) {
        this.projectName = projectExp.getProjectName();
        this.projectPeriod = projectExp.getProjectPeriod();
        this.memberCnt = projectExp.getMemberCnt();
        this.summary = projectExp.getSummary();
        this.techEnv = projectExp.getTechEnv();
        this.position = projectExp.getPosition();
        this.function = projectExp.getFunction();
        this.result = projectExp.getResult();
        this.link = projectExp.getLink();
        this.resume = resume;
    }

}
