package com.ssafy.project.api.service;

import com.ssafy.project.api.request.CompanyRequestDto;
import com.ssafy.project.api.request.ReviewRequestDto;
import com.ssafy.project.api.request.ReviewSearchCondition;
import com.ssafy.project.api.response.ReviewResponseListDto;
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
import java.util.Optional;

@Service("reviewService")
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyRepository companyRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public List<ReviewResponseListDto> getReviewList(ReviewSearchCondition condition) {
        return reviewRepository.searchReview(condition);
    }

    @Override
    @Transactional
    public void writeReview(ReviewRequestDto requestDto, Long memberId, Long companyId) {
        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Company> company = companyRepository.findById(companyId);

//        if(!member.isPresent()) ret

        Review review = Review.builder().member(member.get())
                .title(requestDto.getTitle())
                .company(company.get())
                .content(requestDto.getContent())
                .question(requestDto.getQuestion())
                .answer(requestDto.getAnswer())
                .build();

        reviewRepository.save(review);
    }



}
