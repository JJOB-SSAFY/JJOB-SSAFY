package com.ssafy.project.api.service;

import com.ssafy.project.api.request.RecruitRequestDto;
import com.ssafy.project.api.request.RecruitSearchCondition;
import com.ssafy.project.api.response.MainResponseDto;
import com.ssafy.project.api.response.RecruitResponseDto;
import com.ssafy.project.api.response.RecruitResponseListDto;

import java.util.List;

public interface RecruitService {

    List<MainResponseDto> getRecruitOrderByEndDate();
    List<MainResponseDto> getRecruitOrderByStartDate();

    void createRecruit(Long companyId, RecruitRequestDto requestDto, String email);

    List<RecruitResponseListDto> getRecruitList(RecruitSearchCondition condition);

    RecruitResponseDto getRecruitDetail(Long recruitId);

    void updateRecruit(String email, Long recruitId, RecruitRequestDto requestDto);

    void deleteRecruit(String email, Long recruitId);
}
