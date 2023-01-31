package com.ssafy.project.api.service;

import com.ssafy.project.api.request.MyInfoRequestDto;
import com.ssafy.project.api.response.MyInfoGetRes;
import com.ssafy.project.api.response.MyInfoApplyGetRes;
import com.ssafy.project.db.entity.Member;

import java.util.List;

public interface MyInfoService {
    MyInfoGetRes getMyInfo(String email);
    void changePwd(String password, Member member);

    void changeInfo(MyInfoRequestDto myinfo,long id);

    List<MyInfoApplyGetRes> applyStatus(Long id);




//    Member getMemberByEmail(String email);
//
//    void emailCheck(String email);
}
