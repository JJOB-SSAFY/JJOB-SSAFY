package com.ssafy.project.api.response;

import com.ssafy.project.db.entity.Review;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponseDto{

    private String title;
    private String content;
    private String question;
    private String answer;



    public static ReviewResponseDto of(Review dto){
        return ReviewResponseDto.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .question(dto.getQuestion())
                .answer(dto.getAnswer())
                .build();
    }




}
