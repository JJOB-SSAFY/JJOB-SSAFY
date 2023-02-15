package com.ssafy.project.api.controller;

import com.ssafy.project.api.request.MemberJoinPostReq;
import com.ssafy.project.api.request.MemberLoginPostReq;
import com.ssafy.project.api.response.MemberLoginPostRes;
import com.ssafy.project.api.service.MemberService;
import com.ssafy.project.api.response.BaseResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<BaseResponseBody> join(@RequestBody MemberJoinPostReq joinInfo) {
        //임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.
        System.out.println(joinInfo.getName());
        memberService.join(joinInfo);

        return new ResponseEntity<>(new BaseResponseBody("Success", 201), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberLoginPostRes> login(@RequestBody MemberLoginPostReq loginInfo) {

        return new ResponseEntity<>(memberService.login(loginInfo), HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<BaseResponseBody> emailCheck(@PathVariable String email) {
        memberService.emailCheck(email);
        return new ResponseEntity<>(new BaseResponseBody("Success", 200), HttpStatus.OK);
    }

}
