package com.ssafy.project.db.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.project.api.request.RecruitSearchCondition;
import com.ssafy.project.api.response.QRecruitResponseListDto;
import com.ssafy.project.api.response.RecruitResponseListDto;
import com.ssafy.project.db.entity.QRecruit;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.ssafy.project.db.entity.QCompany.company;
import static com.ssafy.project.db.entity.QRecruit.recruit;
import static org.springframework.util.StringUtils.hasText;

@RequiredArgsConstructor
public class RecruitRepositoryImpl implements RecruitRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<RecruitResponseListDto> getRecruitByLocationAndDepartment(RecruitSearchCondition condition) {
        return queryFactory
                .select(new QRecruitResponseListDto(
                        recruit.id,
                        recruit.recruitTitle,
                        recruit.department,
                        recruit.workType,
                        recruit.work,
                        recruit.requirement,
                        recruit.recruitEndDate,
                        recruit.company.companyName,
                        recruit.location,
                        recruit.recruitStartDate
                ))
                .from(recruit)
                .where(careerEq(condition.getCareer()), locationEq(condition.getLocation()), departmentEq(condition.getDepartment()))
                .fetch();
    }

    private BooleanExpression careerEq(String career) {
        return hasText(career) ? recruit.career.eq(career) : null;
    }

    private BooleanExpression locationEq(String location) {
        return hasText(location) ? recruit.location.contains(location) : null;
    }
    private BooleanExpression departmentEq(String department) {
        return hasText(department) ? recruit.department.contains(department) : null;
    }


}
