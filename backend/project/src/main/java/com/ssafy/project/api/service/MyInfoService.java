package com.ssafy.project.api.service;

import com.ssafy.project.api.request.MyInfoRequestDto;
import com.ssafy.project.api.response.ApplyStatusRes;
import com.ssafy.project.api.response.MyInfoGetRes;
import com.ssafy.project.db.entity.Member;

import java.util.List;

public interface MyInfoService {
    MyInfoGetRes getMyInfo(String email);
    String changePwd(String change,String current, String email);

    void changeInfo(MyInfoRequestDto myInfo, String email);

    List<ApplyStatusRes> applyStatus(String email);




//    Member getMemberByEmail(String email);
//
//    void emailCheck(String email);
}
