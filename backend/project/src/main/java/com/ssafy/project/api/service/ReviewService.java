package com.ssafy.project.api.service;

import com.ssafy.project.api.request.CompanyRequestDto;
import com.ssafy.project.api.request.ReviewRequestDto;
import com.ssafy.project.api.request.ReviewSearchCondition;
import com.ssafy.project.api.response.ReviewResponseDto;
import com.ssafy.project.api.response.ReviewResponseListDto;
import com.ssafy.project.db.entity.Company;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.entity.Review;

import java.util.List;

public interface ReviewService {

    List<ReviewResponseListDto> getReviewList(ReviewSearchCondition condition);
    void writeReview(ReviewRequestDto requestDto, String email, Long companyId);

    ReviewResponseDto getDetailReview(Long reviewId);

    void deleteReview(Long reviewId);

    ReviewResponseDto updateReview(Long reviewId, ReviewRequestDto requestDto);
}
