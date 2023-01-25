package com.ssafy.project.api.service;

import com.ssafy.project.api.request.MemberJoinPostReq;
import com.ssafy.project.db.entity.Member;

public interface MemberService {
    Member join(MemberJoinPostReq memberRegisterInfo);

    Member getMemberByEmail(String email);

    void emailCheck(String email);
}
