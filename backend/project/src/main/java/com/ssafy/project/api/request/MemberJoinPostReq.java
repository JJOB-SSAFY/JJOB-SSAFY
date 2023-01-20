package com.ssafy.project.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberJoinPostReq {

    private String email;

    private String password;

    private String name;

    private String phone;
}
