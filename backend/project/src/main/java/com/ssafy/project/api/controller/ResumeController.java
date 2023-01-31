package com.ssafy.project.api.controller;


import com.ssafy.project.api.request.resume.ResumeRequestDto;
import com.ssafy.project.api.response.BaseResponseBody;
import com.ssafy.project.api.response.ResumeListResponseDto;
import com.ssafy.project.api.service.ResumeService;
import com.ssafy.project.common.auth.SsafyUserDetails;
import com.ssafy.project.db.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resume")
@RequiredArgsConstructor
public class ResumeController{

    private final ResumeService resumeService;

    @GetMapping
    ResponseEntity<List<ResumeListResponseDto>> getResumeList(@AuthenticationPrincipal SsafyUserDetails userDetails){

        return new ResponseEntity<>(resumeService.getResumeList(userDetails.getMember().getEmail()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BaseResponseBody> createResume(@AuthenticationPrincipal SsafyUserDetails userDetails,
                                                         @RequestBody ResumeRequestDto requestDto) {
        System.out.println(requestDto.getName());
        System.out.println(requestDto.getEducationDtoList().get(0).getEducationName());
        return null;
    }
}
