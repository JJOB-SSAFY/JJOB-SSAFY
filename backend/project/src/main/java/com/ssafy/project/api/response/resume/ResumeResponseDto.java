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

    private Boolean isOpened;

    private Boolean isApplied;

    private String imageUrl;

    @Builder.Default
    private List<UniversityResponseDto> universityDtoList = new ArrayList<>();

    @Builder.Default
    private List<EducationResponseDto> educationDtoList = new ArrayList<>();

    @Builder.Default
    private List<ActivityResponseDto> activityDtoList = new ArrayList<>();

    @Builder.Default
    private List<CareerResponseDto> careerDtoList = new ArrayList<>();

    @Builder.Default
    private List<AwardResponseDto> awardDtoList = new ArrayList<>();

    @Builder.Default
    private List<CertificateResponseDto> certificateDtoList = new ArrayList<>();

    @Builder.Default
    private List<LanguageAbilityResponseDto> languageAbilityDtoList = new ArrayList<>();

    @Builder.Default
    private List<SkillResponseDto> skillDtoList = new ArrayList<>();

    @Builder.Default
    private List<ProjectExpResponseDto> projectExpDtoList = new ArrayList<>();

    @Builder.Default
    private List<CoverLetterResponseDto> coverLetterDtoList = new ArrayList<>();

    public static ResumeResponseDto of(Resume dto, List<ActivityResponseDto> activityDtoList, List<AwardResponseDto> awardDtoList,
                                       List<CareerResponseDto> careerDtoList, List<CertificateResponseDto> certificateDtoList,
                                       List<CoverLetterResponseDto> coverLetterDtoList, List<EducationResponseDto> educationDtoList,
                                       List<LanguageAbilityResponseDto> languageAbilityDtoList, List<ProjectExpResponseDto> projectExpDtoList,
                                       List<SkillResponseDto> skillResponseDtoList, List<UniversityResponseDto> universityDtoList,
                                       String imageUrl
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
                .isOpened(dto.getIsOpened())
                .isApplied(dto.getIsApplied())
                .imageUrl(imageUrl)
                .build();
    }

}
