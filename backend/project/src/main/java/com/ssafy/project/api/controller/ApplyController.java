package com.ssafy.project.api.controller;

import com.ssafy.project.api.request.ApplyRequestDto;
import com.ssafy.project.api.response.ApplyCompRes;
import com.ssafy.project.api.response.BaseResponseBody;
import com.ssafy.project.api.service.ApplyService;
import com.ssafy.project.common.auth.SsafyUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apply")
@RequiredArgsConstructor
public class ApplyController {

    private final ApplyService applyService;

    @PostMapping("/{recruit_id}/{resume_id}")
    public ResponseEntity<BaseResponseBody> createApply(@AuthenticationPrincipal SsafyUserDetails userDetails, @PathVariable Long recruit_id,
                                                        @PathVariable Long resume_id, @RequestBody ApplyRequestDto requestDto){

        applyService.createApply(recruit_id, resume_id, userDetails.getMember().getId(), requestDto);

        return new ResponseEntity<>(new BaseResponseBody("Success", 201), HttpStatus.CREATED);
    }


    @GetMapping("/{recruit_id}")
    ResponseEntity<List<ApplyCompRes>> getApplyList(@PathVariable Long recruit_id){
        return new ResponseEntity<>(applyService.getApplyList(recruit_id), HttpStatus.OK);
    }



}
