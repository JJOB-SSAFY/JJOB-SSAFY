package com.ssafy.project.api.controller;

import com.ssafy.project.api.request.ReviewSearchCondition;
import com.ssafy.project.api.response.ReviewResponseDto;
import com.ssafy.project.api.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/list")
    public ResponseEntity<List<ReviewResponseDto>> getReviewList(@RequestBody ReviewSearchCondition condition) {
        return ResponseEntity.ok(reviewService.getReviewList(condition));
    }

}
