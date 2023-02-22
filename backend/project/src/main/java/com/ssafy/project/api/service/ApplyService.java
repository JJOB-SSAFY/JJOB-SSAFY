package com.ssafy.project.api.service;

import com.ssafy.project.api.request.ApplyRequestDto;
import com.ssafy.project.api.response.ApplyCompRes;

import java.util.List;

public interface ApplyService {

    void createApply(Long recruitId, Long resumeId, String email, ApplyRequestDto requestDto);
    void updateApplyStatus(Long applyId, ApplyRequestDto requestDto);
    void deleteApplyStatus(Long applyId);
    List<ApplyCompRes> getApplyList(Long companyId);
}
