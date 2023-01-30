package com.ssafy.project.api.service;

import com.ssafy.project.api.request.RecruitRequestDto;
import com.ssafy.project.api.request.RecruitSearchCondition;
import com.ssafy.project.api.response.MainResponseDto;
import com.ssafy.project.api.response.RecruitResponseDto;
import com.ssafy.project.api.response.RecruitResponseListDto;

import java.util.List;

public interface RecruitService {

    List<MainResponseDto> getRecruitOrderByDate();

    void createRecruit(Long companyId, RecruitRequestDto requestDto);

    List<RecruitResponseListDto> getReviewList(RecruitSearchCondition condition);

    RecruitResponseDto getRecruitDetail(Long recruitId);
}
