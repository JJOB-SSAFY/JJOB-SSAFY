package com.ssafy.project.api.request.resume;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class LanguageAbilityRequestDto {

    private String language;

    private String testName;

    private String grade;

    private String testDate;
}
