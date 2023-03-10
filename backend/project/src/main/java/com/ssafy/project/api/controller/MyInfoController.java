package com.ssafy.project.api.controller;

import com.ssafy.project.api.request.MyInfoRequestDto;
import com.ssafy.project.api.response.ApplyStatusRes;
import com.ssafy.project.api.response.BaseResponseBody;
import com.ssafy.project.api.response.MyInfoGetRes;
import com.ssafy.project.api.service.MyInfoService;
import com.ssafy.project.common.auth.SsafyUserDetails;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/myinfo")
@RequiredArgsConstructor
public class MyInfoController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    private final MyInfoService myInfoService;

    // 내 정보 조회
    @GetMapping("")
    public ResponseEntity<?> getMyInfo(@AuthenticationPrincipal SsafyUserDetails userDetails) {
        logger.info(userDetails.getEmail());
        MyInfoGetRes myInfo = myInfoService.getMyInfo(userDetails.getEmail());

        return new ResponseEntity<MyInfoGetRes>(myInfo, HttpStatus.OK);
    }

    @PatchMapping("/pwd")
    public ResponseEntity<BaseResponseBody> changePwd(@AuthenticationPrincipal SsafyUserDetails userDetails,
                                                      @RequestBody Map<String,String> map) {

        String status = myInfoService.changePwd(map.get("change"), map.get("current"), userDetails.getEmail());
        return new ResponseEntity<>(new BaseResponseBody(status, 200), HttpStatus.OK);
    }

    //내 정보 수정
    @PatchMapping("")
    public ResponseEntity<BaseResponseBody> changeInfo(@AuthenticationPrincipal SsafyUserDetails userDetails,
                                                       @RequestBody MyInfoRequestDto requestDto){
        myInfoService.changeInfo(requestDto, userDetails.getEmail());

        return new ResponseEntity<>(new BaseResponseBody("Success", 200), HttpStatus.OK);
    }

    // 지원현황
    @GetMapping("/apply")
    public ResponseEntity<?> applyStatus(@AuthenticationPrincipal SsafyUserDetails userDetails) {
        return new ResponseEntity<List<ApplyStatusRes>>(myInfoService.applyStatus(userDetails.getEmail()),HttpStatus.OK);
    }

}
