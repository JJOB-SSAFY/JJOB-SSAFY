package com.ssafy.project.api.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDto {

    private String title;
    private String content;
    private String name;
    private String question;
    private String answer;

}
