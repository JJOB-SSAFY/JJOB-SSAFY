package com.ssafy.project.api.controller;


import com.ssafy.project.api.request.resume.ResumeRequestDto;
import com.ssafy.project.api.response.BaseResponseBody;
import com.ssafy.project.api.response.resume.ResumeListResponseDto;
import com.ssafy.project.api.response.resume.ResumeResponseDto;
import com.ssafy.project.api.service.ResumeService;
import com.ssafy.project.common.auth.SsafyUserDetails;
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
    ResponseEntity<List<ResumeListResponseDto>> getResumeList(@AuthenticationPrincipal SsafyUserDetails userDetails) {
        return new ResponseEntity<>(resumeService.getResumeList(userDetails.getMember().getId()), HttpStatus.OK);
    }

    @GetMapping("/isapplied")
    ResponseEntity<List<ResumeListResponseDto>> getIsAppliedResumeList(@AuthenticationPrincipal SsafyUserDetails userDetails) {
        return new ResponseEntity<>(resumeService.getIsAppliedResumeList(userDetails.getMember().getId()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BaseResponseBody> createResume(@AuthenticationPrincipal SsafyUserDetails userDetails,
                                                         @RequestBody ResumeRequestDto requestDto) {
        System.out.println(requestDto);
        resumeService.createResume(requestDto, userDetails.getMember().getId());
        return new ResponseEntity<>(new BaseResponseBody("Success", 201), HttpStatus.CREATED);
    }

    @PatchMapping("/{resume_id}")
    ResponseEntity<BaseResponseBody> updateResume(@PathVariable Long resume_id, @RequestBody ResumeRequestDto requestDto) {
        resumeService.updateResume(requestDto, resume_id);
        return new ResponseEntity<>(new BaseResponseBody("Success", 201), HttpStatus.CREATED);
    }

    @DeleteMapping("/{resume_id}")
    ResponseEntity<BaseResponseBody> deleteResume(@PathVariable Long resume_id) {
        resumeService.deleteResume(resume_id);
        return new ResponseEntity<>(new BaseResponseBody("Success", 201), HttpStatus.CREATED);
    }

    @GetMapping("/{resume_id}")
    ResponseEntity<ResumeResponseDto> getResume(@PathVariable Long resume_id) {
        return new ResponseEntity<>(resumeService.getResume(resume_id), HttpStatus.OK);
    }

    @PatchMapping("/change/status/{resume_id}")
    public ResponseEntity<BaseResponseBody> changeApplyStatus(@PathVariable Long resume_id) {
        resumeService.changeApplyStatus(resume_id);
        return new ResponseEntity<>(new BaseResponseBody("Success", 201), HttpStatus.OK);
    }
}
