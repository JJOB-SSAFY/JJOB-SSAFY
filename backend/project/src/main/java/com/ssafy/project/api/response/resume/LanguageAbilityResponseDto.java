package com.ssafy.project.api.response.resume;

import com.ssafy.project.db.entity.resume.LanguageAbility;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LanguageAbilityResponseDto {

    private String language;

    private String testName;

    private String grade;

    private String testDate;

    public LanguageAbilityResponseDto(LanguageAbility languageAbility) {
        this.language = languageAbility.getLanguage();
        this.testName = languageAbility.getTestName();
        this.grade = languageAbility.getGrade();
        this.testDate = languageAbility.getTestDate();
    }

}
