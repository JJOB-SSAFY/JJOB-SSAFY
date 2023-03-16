package com.ssafy.project.api.request.resume;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class ProjectExpRequestDto {

    private String projectName;

    private String projectPeriod;

    private String memberCnt;

    private String summary;

    private String techEnv;

    private String position;

    private String functions;

    private String result;

    private String link;
}
