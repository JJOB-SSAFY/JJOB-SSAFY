package com.ssafy.project.api.response.resume;

import com.ssafy.project.db.entity.resume.Skill;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SkillResponseDto {

    private String skillName;

    private String skillLevel;

    private String detail;

    public SkillResponseDto(Skill skill) {
        this.skillName = skill.getSkillName();
        this.skillLevel = skill.getSkillLevel();
        this.detail = skill.getDetail();
    }
}
