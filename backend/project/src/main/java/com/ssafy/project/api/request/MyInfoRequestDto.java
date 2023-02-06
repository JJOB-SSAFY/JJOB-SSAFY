package com.ssafy.project.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyInfoRequestDto {

    private String phone;
    private String blog;
    private String github;
    private String skills;
    private String preferredJob;
    private String introduce;
    private String imageUrl;
    private boolean visible;

}
