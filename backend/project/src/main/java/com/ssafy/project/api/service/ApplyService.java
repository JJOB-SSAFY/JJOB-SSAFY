package com.ssafy.project.api.service;

import com.ssafy.project.api.request.ApplyRequestDto;
import com.ssafy.project.api.response.ApplyCompRes;
import com.ssafy.project.api.response.ApplyStatusRes;

import java.util.List;

public interface ApplyService {

    void createApply(Long recruitId, Long resumeId, Long memberId, ApplyRequestDto requestDto);
    ApplyStatusRes updateApplyStatus(Long recruitId, Long memberId, ApplyRequestDto requestDto);
    void deleteApply(Long recruitId);
    List<ApplyCompRes> getApplyList(Long recruitId);


}
