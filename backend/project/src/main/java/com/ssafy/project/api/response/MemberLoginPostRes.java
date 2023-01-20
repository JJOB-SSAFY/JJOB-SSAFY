package com.ssafy.project.api.response;

import com.ssafy.project.common.model.response.BaseResponseBody;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberLoginPostRes extends BaseResponseBody {

    private String accessToken;

    public static MemberLoginPostRes of(Integer statusCode, String message, String accessToken) {
        MemberLoginPostRes res = new MemberLoginPostRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.setAccessToken(accessToken);
        return res;
    }

}
