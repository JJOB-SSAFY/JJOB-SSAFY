package com.ssafy.project.api.service;

import com.ssafy.project.api.request.RecruitRequestDto;
import com.ssafy.project.api.response.MainResponseDto;

import java.util.List;

public interface RecruitService {

    List<MainResponseDto> getRecruitOrderByDate();

    void createRecruit(Long companyId, RecruitRequestDto requestDto);
}
