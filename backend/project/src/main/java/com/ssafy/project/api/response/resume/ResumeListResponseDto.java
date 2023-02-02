package com.ssafy.project.api.response.resume;


import com.ssafy.project.db.entity.resume.Resume;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeListResponseDto {
    private Long resumeId;
    private String resumeTitle;

    private String subTitle;

    public ResumeListResponseDto(Resume resume) {
        this.resumeId = resume.getId();
        this.resumeTitle = resume.getResumeTitle();
        this.subTitle = resume.getSubTitle();
    }

    public static ResumeListResponseDto of (Resume dto){
        return ResumeListResponseDto.builder()
                .resumeId(dto.getId())
                .resumeTitle(dto.getResumeTitle())
                .subTitle(dto.getSubTitle())
                .build();
    }




}
