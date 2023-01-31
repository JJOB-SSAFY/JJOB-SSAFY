package com.ssafy.project.api.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MyInfoGetRes {
    private String name;
    private String email;
    private String blog;
    private String phone;
    private String github;
    private String skills;
    private String preferredJob;
    private String introduce;
    private String imgUrl;



}
