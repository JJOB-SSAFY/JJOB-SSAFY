package com.ssafy.project.api.controller;

import com.ssafy.project.api.request.RecruitRequestDto;
import com.ssafy.project.api.request.RecruitSearchCondition;
import com.ssafy.project.api.response.RecruitResponseDto;
import com.ssafy.project.api.response.RecruitResponseListDto;
import com.ssafy.project.api.service.RecruitService;
import com.ssafy.project.api.response.BaseResponseBody;
import com.ssafy.project.common.auth.SsafyUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruit")
@RequiredArgsConstructor
public class RecruitController {

    private final RecruitService recruitService;

    @PostMapping("/{company_id}")
    public ResponseEntity<BaseResponseBody> createRecruit(@AuthenticationPrincipal SsafyUserDetails userDetails,
                                                          @PathVariable Long company_id,
                                                          @RequestBody RecruitRequestDto requestDto) {
        recruitService.createRecruit(company_id, requestDto, userDetails.getMember().getId());
        return new ResponseEntity<>(new BaseResponseBody("Success", 201), HttpStatus.CREATED);
    }

    @PostMapping("/list")
    public ResponseEntity<List<RecruitResponseListDto>> getRecruitList(@RequestBody RecruitSearchCondition condition) {
        return new ResponseEntity<>(recruitService.getReviewList(condition), HttpStatus.OK);
    }

    @GetMapping("/detail/{recruit_id}")
    public ResponseEntity<RecruitResponseDto> getRecruitDetail(@PathVariable Long recruit_id) {
        return new ResponseEntity<>(recruitService.getRecruitDetail(recruit_id), HttpStatus.OK);
    }

    @PatchMapping("/{recruit_id}")
    public ResponseEntity<BaseResponseBody> updateRecruit(@AuthenticationPrincipal SsafyUserDetails userDetails,
                                                            @PathVariable Long recruit_id,
                                                            @RequestBody RecruitRequestDto requestDto) {
        recruitService.updateRecruit(userDetails.getMember().getId(), recruit_id, requestDto);
        return new ResponseEntity<>(new BaseResponseBody("Success", 200), HttpStatus.OK);
    }

    @DeleteMapping("/{recruit_id}")
    public ResponseEntity<BaseResponseBody> deleteRecruit(@AuthenticationPrincipal SsafyUserDetails userDetails,
                                                          @PathVariable Long recruit_id) {
        recruitService.deleteRecruit(userDetails.getMember().getId(), recruit_id);
        return new ResponseEntity<>(new BaseResponseBody("Success", 200), HttpStatus.OK);
    }
}
