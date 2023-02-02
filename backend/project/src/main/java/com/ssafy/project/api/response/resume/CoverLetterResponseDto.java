package com.ssafy.project.api.response.resume;

import com.ssafy.project.db.entity.resume.CoverLetter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CoverLetterResponseDto {

    private String title;

    private String content;

    public CoverLetterResponseDto(CoverLetter coverLetter) {
        this.title = coverLetter.getTitle();
        this.content = coverLetter.getContent();
    }

}
