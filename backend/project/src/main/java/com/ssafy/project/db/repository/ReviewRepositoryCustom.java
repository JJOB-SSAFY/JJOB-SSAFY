package com.ssafy.project.db.repository;

import com.ssafy.project.api.request.ReviewSearchCondition;
import com.ssafy.project.api.response.ReviewResponseDto;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<ReviewResponseDto> searchReview(ReviewSearchCondition condition);
}
