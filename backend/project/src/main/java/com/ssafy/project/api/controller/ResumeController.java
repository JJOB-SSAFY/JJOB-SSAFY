package com.ssafy.project.api.controller;


import com.ssafy.project.api.response.ResumeListResponseDto;
import com.ssafy.project.api.service.ResumeService;
import com.ssafy.project.common.auth.SsafyUserDetails;
import com.ssafy.project.db.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resume")
@RequiredArgsConstructor
public class ResumeController{

    private final ResumeService resumeService;

    @GetMapping
    ResponseEntity<List<ResumeListResponseDto>> getResumeList(@AuthenticationPrincipal SsafyUserDetails userDetails){

        return ResponseEntity.ok(resumeService.getResumeList(userDetails.getMember().getEmail()));
    }

}
