package com.ssafy.project.api.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewResponseListDto {

    private Long reviewId;
    private String name;
    private String title;
    private String content;
    private String question;
    private String answer;
    private String companyLogo;
    @QueryProjection
    public ReviewResponseListDto(Long reviewId, String name, String title, String content, String question, String answer,String companyLogo) {
        this.reviewId = reviewId;
        this.name = name;
        this.title = title;
        this.content = content;
        this.question = question;
        this.answer = answer;
        this.companyLogo=companyLogo;
    }
}
