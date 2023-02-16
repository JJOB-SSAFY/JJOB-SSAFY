package com.ssafy.project.db.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.project.api.request.CardSearchCondition;
import com.ssafy.project.api.response.CardResponseListDto;
import com.ssafy.project.api.response.QCardResponseListDto;
import com.ssafy.project.db.entity.QCard;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepositoryCustom {

    private final JPAQueryFactory queryFactory;


    @Override
    public List<CardResponseListDto> getCardBySkillsAndNameAndPreferredJobAndVisible(CardSearchCondition condition) {
        return queryFactory
                .select(new QCardResponseListDto(
                        QCard.card.preferredJob,
                        QCard.card.skills,
                        QCard.card.introduce,
                        QCard.card.blog,
                        QCard.card.github,
                        QCard.card.phone,
                        QCard.card.email,
                        QCard.card.name,
                        QCard.card.imageUrl,
                        QCard.card.id
                ))
                .from(QCard.card)
                .where(allEq(condition.getSkills(), condition.getPreferredJob(), condition.getName()))
                .fetch();
    }
    private BooleanExpression skillsEq(String skills){
        return StringUtils.hasText(skills) ? QCard.card.skills.contains(skills) : null;
    }

    private BooleanExpression preferredJobEq(String preferredJob){
        return StringUtils.hasText(preferredJob) ? QCard.card.preferredJob.contains(preferredJob) : null;
    }

    private BooleanExpression nameEq(String name){
        return StringUtils.hasText(name) ? QCard.card.name.contains(name) : null;
    }

    private BooleanExpression visibleEq() {
        return QCard.card.visible.eq(true);
    }

    private BooleanExpression allEq(String skills, String preferredJob, String name) {
        return skillsEq(skills).and(preferredJobEq(preferredJob)).and(nameEq(name)).and(visibleEq());
    }

}
