package com.ssafy.project.api.service;

import com.ssafy.project.api.request.ReviewRequestDto;
import com.ssafy.project.api.response.ReviewResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ReviewServiceImplTest {

    @Autowired
    private ReviewService reviewService;

    @Test
    @DisplayName("리뷰 작성 성공")
    public void writeReviewSuccessTest() {

        // Given
        String email = "test@test.com";
        Long companyId = 1L;
        ReviewRequestDto requestDto = new ReviewRequestDto(
                "title",
                "content",
                "question",
                "answer"
        );

        // When
        ReviewResponseDto reviewResponseDto = reviewService.writeReview(requestDto, email, companyId);

        // Then
        Assertions.assertEquals("title", reviewResponseDto.getTitle());
        Assertions.assertEquals("content", reviewResponseDto.getContent());
        Assertions.assertEquals("question", reviewResponseDto.getQuestion());
        Assertions.assertEquals("answer", reviewResponseDto.getAnswer());
    }

}