package com.ssafy.project.api.response;

import com.querydsl.core.annotations.QueryProjection;
import com.ssafy.project.db.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewResponseDto {

    private String name;
    private String content;

    @QueryProjection
    public ReviewResponseDto(String name, String content) {
        this.name = name;
        this.content = content;
    }
}
