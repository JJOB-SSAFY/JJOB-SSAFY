package com.ssafy.project.api.service;

import com.ssafy.project.api.request.ReviewSearchCondition;
import com.ssafy.project.api.response.ReviewResponseDto;

import java.util.List;

public interface ReviewService {

    List<ReviewResponseDto> getReviewList(ReviewSearchCondition condition);
}
