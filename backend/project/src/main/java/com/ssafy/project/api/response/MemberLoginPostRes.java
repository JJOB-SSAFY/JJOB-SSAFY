package com.ssafy.project.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberLoginPostRes {

    private String accessToken;

    public static MemberLoginPostRes from(String accessToken) {
        return MemberLoginPostRes.builder()
                .accessToken(accessToken)
                .build();
    }

}
