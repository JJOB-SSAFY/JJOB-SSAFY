package com.ssafy.project.api.response;

import com.ssafy.project.db.entity.MemberRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberLoginPostRes {

    private String accessToken;
    private String name;
    private String role;

    public static MemberLoginPostRes from(String accessToken, String name, String role) {
        return MemberLoginPostRes.builder()
                .accessToken(accessToken)
                .name(name)
                .role(role)
                .build();
    }

}
