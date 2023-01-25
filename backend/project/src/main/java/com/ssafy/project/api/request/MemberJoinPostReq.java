package com.ssafy.project.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberJoinPostReq {

    private String email;

    private String password;

    private String name;

    private String phone;
}
