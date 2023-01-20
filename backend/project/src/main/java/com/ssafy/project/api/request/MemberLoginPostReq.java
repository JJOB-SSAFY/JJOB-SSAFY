package com.ssafy.project.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberLoginPostReq {

    private String email;

    private String password;

}
