package com.ssafy.project.db.repository;

import com.ssafy.project.api.request.ReviewSearchCondition;
import com.ssafy.project.api.response.ReviewResponseListDto;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<ReviewResponseListDto> searchReview(ReviewSearchCondition condition);
}
