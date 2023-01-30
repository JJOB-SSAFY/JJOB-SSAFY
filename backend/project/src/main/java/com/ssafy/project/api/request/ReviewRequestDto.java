package com.ssafy.project.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDto {
//    {
//        title: title,
//                content: content,
//            name: name,
//            question: question,
//            answer: answer
//    }


    private String title;
    private String content;

    private String question;
    private String answer;


}
