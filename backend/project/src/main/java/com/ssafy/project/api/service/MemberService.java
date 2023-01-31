package com.ssafy.project.api.service;

import com.ssafy.project.api.request.MemberJoinPostReq;
import com.ssafy.project.api.request.MemberLoginPostReq;
import com.ssafy.project.api.response.MemberLoginPostRes;
import com.ssafy.project.db.entity.Member;

public interface MemberService {
    void join(MemberJoinPostReq joinInfo);

    MemberLoginPostRes login(MemberLoginPostReq loginInfo);

    void emailCheck(String email);
}
