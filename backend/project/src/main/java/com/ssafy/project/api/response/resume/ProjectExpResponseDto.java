package com.ssafy.project.api.response.resume;

import com.ssafy.project.db.entity.resume.ProjectExp;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectExpResponseDto {

    private String projectName;

    private String projectPeriod;

    private String memberCnt;

    private String summary;

    private String techEnv;

    private String position;

    private String function;

    private String result;

    private String link;

    public ProjectExpResponseDto(ProjectExp projectExp) {
        this.projectName = projectExp.getProjectName();
        this.projectPeriod = projectExp.getMemberCnt();
        this.memberCnt = projectExp.getMemberCnt();
        this.summary = projectExp.getSummary();
        this.techEnv = projectExp.getTechEnv();
        this.position = projectExp.getPosition();
        this.function = projectExp.getFunction();
        this.result = projectExp.getResult();
        this.link = projectExp.getLink();

    }


}
