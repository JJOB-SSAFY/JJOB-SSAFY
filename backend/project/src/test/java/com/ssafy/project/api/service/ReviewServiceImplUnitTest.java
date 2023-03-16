package com.ssafy.project.api.service;

import com.ssafy.project.api.request.ReviewRequestDto;
import com.ssafy.project.api.response.ReviewResponseDto;
import com.ssafy.project.db.entity.Company;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.entity.Review;
import com.ssafy.project.db.repository.CompanyRepository;
import com.ssafy.project.db.repository.MemberRepository;
import com.ssafy.project.db.repository.ReviewRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ReviewServiceImplUnitTest {

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private MemberRepository memberRepository;

    @Test
    @DisplayName("리뷰 상세 조회 성공")
    public void getDetailReview() {

        // Given
        Long reviewId = 1L;
        ReviewRequestDto requestDto = new ReviewRequestDto(
                "title",
                "content",
                "question",
                "answer"
        );

        Review review = Review.of(getMember(), getCompany(), requestDto);

        ReviewServiceImpl reviewService = new ReviewServiceImpl(reviewRepository, companyRepository, memberRepository);
        given(this.reviewRepository.findById(reviewId))
                .willReturn(Optional.ofNullable(review));

        // When
        ReviewResponseDto reviewResponseDto = reviewService.getDetailReview(reviewId);

        // Then
        Assertions.assertEquals("title", reviewResponseDto.getTitle());
        Assertions.assertEquals("content", reviewResponseDto.getContent());
        Assertions.assertEquals("question", reviewResponseDto.getQuestion());
        Assertions.assertEquals("answer", reviewResponseDto.getAnswer());
    }

    private Member getMember() {
        return Member.builder()
                .email("test@test.com")
                .password("1111")
                .name("kiyoom")
                .build();
    }

    private Company getCompany() {
        return Company.builder()
                .companyName("삼성")
                .companyUrl("www.samsung.com")
                .companyAddress("삼성시")
                .employeeCnt(500)
                .companyDesc("반도체")
                .build();
    }
}