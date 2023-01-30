package com.ssafy.project.api.controller;

import com.ssafy.project.api.request.MemberJoinPostReq;
import com.ssafy.project.api.response.MyInfoGetRes;
import com.ssafy.project.api.service.MemberService;
import com.ssafy.project.api.service.MyInfoService;
import com.ssafy.project.common.auth.SsafyUserDetails;
import com.ssafy.project.common.model.response.BaseResponseBody;
import com.ssafy.project.db.entity.Member;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/myinfo")
@RequiredArgsConstructor
public class MyInfoController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    private final MemberService memberService;
    private final MyInfoService myInfoService;

    @GetMapping
    public ResponseEntity<?> test(){
        logger.info("함시연");
        return null;
    }
    // 내 정보 조회
    @GetMapping("/{email}")
    public ResponseEntity<? extends BaseResponseBody> getMyInfo(@AuthenticationPrincipal SsafyUserDetails userDetails, @PathVariable("email") String email) {
        //임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.
        MyInfoGetRes myInfo = myInfoService.getMyInfo(email);

        System.out.println(myInfo);
        return new ResponseEntity<MyInfoGetRes>(myInfo, HttpStatus.ACCEPTED);
    }
//    @GetMapping("/{email}")
//    public ResponseEntity<? extends BaseResponseBody> emailCheck(@PathVariable String email) {
//        memberService.emailCheck(email);
//        return ResponseEntity.status(201).body(BaseResponseBody.of(200, "사용 가능한 이메일 입니다"));
//    }

}
