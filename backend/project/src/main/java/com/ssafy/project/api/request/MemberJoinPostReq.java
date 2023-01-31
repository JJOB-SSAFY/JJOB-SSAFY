package com.ssafy.project.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberJoinPostReq {

    private String email;

    private String password;

    private String name;

    private String phone;

    private String companyName;

}
