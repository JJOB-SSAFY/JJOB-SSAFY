package com.ssafy.project.db.repository;

import com.ssafy.project.api.request.RecruitSearchCondition;
import com.ssafy.project.api.response.RecruitResponseListDto;

import java.util.List;

public interface RecruitRepositoryCustom {
    List<RecruitResponseListDto> getRecruitByLocationAndDepartment(RecruitSearchCondition condition);
}
