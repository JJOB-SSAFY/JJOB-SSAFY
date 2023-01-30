package com.ssafy.project.api.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewResponseListDto {

    private String name;
    private String content;

    @QueryProjection
    public ReviewResponseListDto(String name, String content) {
        this.name = name;
        this.content = content;
    }
}
