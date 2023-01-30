package com.ssafy.project.api.controller;

import com.ssafy.project.api.request.ReviewRequestDto;
import com.ssafy.project.api.request.ReviewSearchCondition;
import com.ssafy.project.api.response.ReviewResponseListDto;
import com.ssafy.project.api.service.ReviewService;
import com.ssafy.project.common.auth.SsafyUserDetails;
import com.ssafy.project.api.response.BaseResponseBody;
import com.ssafy.project.db.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;


    @GetMapping("/list")
    public ResponseEntity<List<ReviewResponseListDto>> getReviewList(@RequestBody ReviewSearchCondition condition) {
        return ResponseEntity.ok(reviewService.getReviewList(condition));
    }

    @PostMapping("/{company_id}")
    public ResponseEntity<? extends BaseResponseBody> writeReview(@AuthenticationPrincipal SsafyUserDetails userDetails, @PathVariable String company_id, @RequestBody ReviewRequestDto requestDto){

        Member member = userDetails.getMember();

        Long companyId = Long.parseLong(company_id);

        reviewService.writeReview(requestDto, userDetails.getMember().getId(), companyId);


        return ResponseEntity.status(201).body(BaseResponseBody.of(200, "success"));
    }



}
