package com.ssafy.project.api.controller;

import com.ssafy.project.api.request.MemberJoinPostReq;
import com.ssafy.project.api.service.MemberService;
import com.ssafy.project.common.model.response.BaseResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<? extends BaseResponseBody> join(@RequestBody MemberJoinPostReq joinInfo) {
        //임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.
        memberService.join(joinInfo);

        return ResponseEntity.status(201).body(BaseResponseBody.of(201, "Success"));
    }

    @GetMapping("/{email}")
    public ResponseEntity<? extends BaseResponseBody> emailCheck(@PathVariable String email) {
        memberService.emailCheck(email);
        return ResponseEntity.status(201).body(BaseResponseBody.of(200, "사용 가능한 이메일 입니다"));
    }

}
