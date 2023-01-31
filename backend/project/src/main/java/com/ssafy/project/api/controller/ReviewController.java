package com.ssafy.project.api.controller;

import com.ssafy.project.api.request.ReviewRequestDto;
import com.ssafy.project.api.request.ReviewSearchCondition;
import com.ssafy.project.api.response.ReviewResponseDto;
import com.ssafy.project.api.response.ReviewResponseListDto;
import com.ssafy.project.api.service.ReviewService;
import com.ssafy.project.common.auth.SsafyUserDetails;
import com.ssafy.project.api.response.BaseResponseBody;
import com.ssafy.project.db.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        return new ResponseEntity<>(reviewService.getReviewList(condition), HttpStatus.OK);
    }

    @PostMapping("/{company_id}")
    public ResponseEntity<? extends BaseResponseBody> writeReview(@AuthenticationPrincipal SsafyUserDetails userDetails, @PathVariable String company_id, @RequestBody ReviewRequestDto requestDto){
        Long companyId = Long.parseLong(company_id);

        reviewService.writeReview(requestDto, userDetails.getMember().getId(), companyId);

        return new ResponseEntity<>(new BaseResponseBody("Success", 201), HttpStatus.CREATED);
    }

    @GetMapping("/detail/{review_id}")
    public ResponseEntity<ReviewResponseDto> detailReview(@PathVariable Long review_id){
        return new ResponseEntity<>(reviewService.getDetailReview(review_id), HttpStatus.OK);
    }

    @DeleteMapping("/{review_id}")
    public ResponseEntity<? extends BaseResponseBody> deleteReview(@PathVariable Long review_id) {
        reviewService.deleteReview(review_id);
        return new ResponseEntity<>(new BaseResponseBody("Success", 200), HttpStatus.OK);
    }

    @PatchMapping("{review_id}")
    public ResponseEntity<ReviewResponseDto> updateReview(@PathVariable Long review_id,  @RequestBody ReviewRequestDto requestDto){
        return new ResponseEntity<>(reviewService.updateReview(review_id, requestDto), HttpStatus.OK);
    }

}
