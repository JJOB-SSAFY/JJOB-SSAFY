package com.ssafy.project.api.request.resume;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ResumeRequestDto {

    private String resumeTitle;

    private String name;

    private String blog;

    private String phone;

    private String portfolio;

    private String email;

    private String github;

    private Boolean isApplied;

    private List<UniversityRequestDto> universityDtoList = new ArrayList<>();

    private List<EducationRequestDto> educationDtoList = new ArrayList<>();

    private List<ActivityRequestDto> activityDtoList = new ArrayList<>();

    private List<CareerRequestDto> careerDtoList = new ArrayList<>();

    private List<AwardRequestDto> awardDtoList = new ArrayList<>();

    private List<CertificateRequestDto> certificateDtoList = new ArrayList<>();

    private List<LanguageAbilityRequestDto> languageAbilityDtoList = new ArrayList<>();

    private List<SkillRequestDto> skillDtoList = new ArrayList<>();

    private List<ProjectExpRequestDto> projectExpDtoList = new ArrayList<>();

    private List<CoverLetterRequestDto> coverLetterDtoList = new ArrayList<>();
}
