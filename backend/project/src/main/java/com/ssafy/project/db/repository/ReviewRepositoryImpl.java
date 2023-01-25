package com.ssafy.project.db.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.project.api.request.ReviewSearchCondition;
import com.ssafy.project.api.response.QReviewResponseDto;
import com.ssafy.project.api.response.ReviewResponseDto;
import com.ssafy.project.db.entity.QCompany;
import com.ssafy.project.db.entity.Review;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.ssafy.project.db.entity.QCompany.company;
import static com.ssafy.project.db.entity.QReview.review;
import static org.springframework.util.StringUtils.hasText;

@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ReviewResponseDto> searchReview(ReviewSearchCondition condition) {
        return queryFactory
                .select(new QReviewResponseDto(review.member.name, review.content))
                .from(review)
                .join(review.company, company)
                .where(companyEq(condition.getCompanyName()))
                .fetch();
    }

    private BooleanExpression companyEq(String companyName) {
        return hasText(companyName) ? company.companyName.eq(companyName) : null;
    }
}
