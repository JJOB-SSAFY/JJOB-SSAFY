package com.ssafy.project.api.service;

import com.ssafy.project.api.request.ReviewRequestDto;
import com.ssafy.project.api.request.ReviewSearchCondition;
import com.ssafy.project.api.response.ReviewResponseDto;
import com.ssafy.project.api.response.ReviewResponseListDto;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.db.entity.Company;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.entity.Review;
import com.ssafy.project.db.repository.CompanyRepository;
import com.ssafy.project.db.repository.MemberRepository;
import com.ssafy.project.db.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("reviewService")
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyRepository companyRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ReviewResponseListDto> getReviewList(ReviewSearchCondition condition) {

        return reviewRepository.searchReview(condition);
    }

    @Override
    @Transactional
    public ReviewResponseDto writeReview(ReviewRequestDto requestDto, String email, Long companyId) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException(ExceptionEnum.MEMBER_EXIST_EXCEPTION));
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ApiException(ExceptionEnum.COMPANY_NOT_EXIST_EXCEPTION));

        Review review = Review.of(member, company, requestDto);

        Review saveReview = reviewRepository.save(review);
        return ReviewResponseDto.of(saveReview);
    }

    @Override
    @Transactional(readOnly = true)
    public ReviewResponseDto getDetailReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ApiException(ExceptionEnum.REVIEW_NOT_EXIST_EXCEPTION));

        return ReviewResponseDto.of(review);
    }

    @Override
    @Transactional
    public void deleteReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ApiException(ExceptionEnum.REVIEW_NOT_EXIST_EXCEPTION));
        reviewRepository.delete(review);
    }

    @Override
    @Transactional
    public ReviewResponseDto updateReview(Long reviewId, ReviewRequestDto requestDto) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ApiException(ExceptionEnum.REVIEW_NOT_EXIST_EXCEPTION));

        review.updateReview(requestDto);

        return ReviewResponseDto.of(review);
    }

}
