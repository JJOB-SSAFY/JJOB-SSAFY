package com.ssafy.project.api.response.resume;

import com.ssafy.project.db.entity.resume.Resume;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ResumeResponseDto {

    private String resumeTitle;

    private String name;

    private String blog;

    private String phone;

    private String portfolio;

    private String email;

    private String github;
    private Boolean isApplied;

    private List<UniversityResponseDto> universityDtoList = new ArrayList<>();

    private List<EducationResponseDto> educationDtoList = new ArrayList<>();

    private List<ActivityResponseDto> activityDtoList = new ArrayList<>();

    private List<CareerResponseDto> careerDtoList = new ArrayList<>();

    private List<AwardResponseDto> awardDtoList = new ArrayList<>();

    private List<CertificateResponseDto> certificateDtoList = new ArrayList<>();

    private List<LanguageAbilityResponseDto> languageAbilityDtoList = new ArrayList<>();

    private List<SkillResponseDto> skillDtoList = new ArrayList<>();

    private List<ProjectExpResponseDto> projectExpDtoList = new ArrayList<>();

    private List<CoverLetterResponseDto> coverLetterDtoList = new ArrayList<>();


    public static ResumeResponseDto of(Resume dto, List<ActivityResponseDto> activityDtoList, List<AwardResponseDto> awardDtoList,
                                       List<CareerResponseDto> careerDtoList, List<CertificateResponseDto> certificateDtoList,
                                       List<CoverLetterResponseDto> coverLetterDtoList, List<EducationResponseDto> educationDtoList,
                                       List<LanguageAbilityResponseDto> languageAbilityDtoList, List<ProjectExpResponseDto> projectExpDtoList,
                                       List<SkillResponseDto> skillResponseDtoList, List<UniversityResponseDto> universityDtoList
                                       ){
        return ResumeResponseDto.builder()
                .resumeTitle(dto.getResumeTitle())
                .name(dto.getName())
                .blog(dto.getBlog())
                .phone(dto.getPhone())
                .portfolio(dto.getPortfolio())
                .email(dto.getEmail())
                .github(dto.getGithub())
                .universityDtoList(universityDtoList)
                .educationDtoList(educationDtoList)
                .activityDtoList(activityDtoList)
                .careerDtoList(careerDtoList)
                .awardDtoList(awardDtoList)
                .certificateDtoList(certificateDtoList)
                .languageAbilityDtoList(languageAbilityDtoList)
                .skillDtoList(skillResponseDtoList)
                .projectExpDtoList(projectExpDtoList)
                .coverLetterDtoList(coverLetterDtoList)
                .isApplied(dto.getIsApplied())
                .build();
    }


}
