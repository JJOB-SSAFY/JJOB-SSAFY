package com.ssafy.project.api.controller;

import com.ssafy.project.api.request.MemberLoginPostReq;
import com.ssafy.project.api.response.MemberLoginPostRes;
import com.ssafy.project.api.service.MemberService;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.common.util.JwtTokenUtil;
import com.ssafy.project.db.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<MemberLoginPostRes> login(@RequestBody MemberLoginPostReq loginInfo) {
        String email = loginInfo.getEmail();
        String password = loginInfo.getPassword();

        Member member = memberService.getMemberByEmail(email);

        // 로그인 요청한 유저로부터 입력된 패스워드 와 디비에 저장된 유저의 암호화된 패스워드가 같은지 확인.(유효한 패스워드인지 여부 확인)
        if (new BCryptPasswordEncoder().matches(password, member.getPassword())) {
            // 유효한 패스워드가 맞는 경우, 로그인 성공으로 응답.(액세스 토큰을 포함하여 응답값 전달)
            return new ResponseEntity<>(MemberLoginPostRes.from(JwtTokenUtil.getToken(email)), HttpStatus.OK);
//            return new ResponseEntity<>(MemberLoginPostRes)
        }
        // 유효하지 않는 패스워드인 경우, 로그인 실패로 응답.
        throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
    }

}
