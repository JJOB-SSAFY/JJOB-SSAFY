package com.ssafy.project.api.service;

import com.ssafy.project.api.request.ReviewSearchCondition;
import com.ssafy.project.api.response.ReviewResponseDto;
import com.ssafy.project.db.entity.Review;
import com.ssafy.project.db.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service("reviewService")
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public List<ReviewResponseDto> getReviewList(ReviewSearchCondition condition) {
        return reviewRepository.searchReview(condition);
    }
}
