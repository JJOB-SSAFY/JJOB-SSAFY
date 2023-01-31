package com.ssafy.project.api.request.resume;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SkillRequestDto {

    private String skillName;

    private String skillLevel;

    private String detail;
}
