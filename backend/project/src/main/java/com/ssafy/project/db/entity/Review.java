package com.ssafy.project.db.entity;

import com.ssafy.project.api.request.ReviewRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    private String question;

    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    public static Review of(Member member, Company company, ReviewRequestDto requestDto) {
        return Review.builder()
                .member(member)
                .title(requestDto.getTitle())
                .company(company)
                .content(requestDto.getContent())
                .question(requestDto.getQuestion())
                .answer(requestDto.getAnswer())
                .build();
    }

    public void updateReview(ReviewRequestDto reviewRequestDto){
        this.title = reviewRequestDto.getTitle();
        this.answer = reviewRequestDto.getAnswer();
        this.content = reviewRequestDto.getContent();
        this.question = reviewRequestDto.getQuestion();
    }

}
