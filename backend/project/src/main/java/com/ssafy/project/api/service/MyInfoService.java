package com.ssafy.project.api.service;

import com.ssafy.project.api.response.MyInfoGetRes;

public interface MyInfoService {
    MyInfoGetRes getMyInfo(String email);

//    Member getMemberByEmail(String email);
//
//    void emailCheck(String email);
}
