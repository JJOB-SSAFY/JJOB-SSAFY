package com.ssafy.project.api.controller;

import com.ssafy.project.api.request.MyInfoRequestDto;
import com.ssafy.project.api.response.MyInfoGetRes;
import com.ssafy.project.api.service.MemberService;
import com.ssafy.project.api.service.MyInfoService;
import com.ssafy.project.common.auth.SsafyUserDetails;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity<?> getMyInfo(@AuthenticationPrincipal SsafyUserDetails userDetails, @PathVariable("email") String email) {
        logger.info(email);
        MyInfoGetRes myInfo = myInfoService.getMyInfo(email);


        return new ResponseEntity<MyInfoGetRes>(myInfo, HttpStatus.OK);
    }
    @PatchMapping("/pwd")
    public ResponseEntity<?> changePwd(@AuthenticationPrincipal SsafyUserDetails userDetails,@RequestBody Map<String,String> map){
//        logger.info(userDetails.getMember().getEmail());
//        logger.info(map.get("password"));
//        logger.info(new BCryptPasswordEncoder().encode(map.get("password")));
        myInfoService.changePwd(map.get("password"),userDetails.getMember());
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
    //내 정보 수정
    @PatchMapping("/{email}")
    public ResponseEntity<?> changeInfo(@AuthenticationPrincipal SsafyUserDetails userDetails, @RequestBody MyInfoRequestDto requestDto){
        Long id=userDetails.getMember().getId();
        myInfoService.changeInfo(requestDto,id);

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
    // 지원현황
    @GetMapping("/apply/{email}")
    public ResponseEntity<?> applyStatus(@AuthenticationPrincipal SsafyUserDetails userDetails){
        Long id=userDetails.getMember().getId();
        return null;
    }

}