package com.ssafy.project.api.service;

import com.ssafy.project.api.request.resume.ResumeRequestDto;
import com.ssafy.project.api.response.resume.ResumeListResponseDto;
import com.ssafy.project.api.response.resume.ResumeResponseDto;


import java.util.List;

public interface ResumeService {
    List<ResumeListResponseDto> getResumeList(Long memberId);
    void createResume(ResumeRequestDto requestDto, Long memberId);
    void updateResume(ResumeRequestDto requestDto, Long resumeId);
    void deleteResume(Long resumeId);
    ResumeResponseDto getResume(Long resumeId);
    void changeApplyStatus(Long resumeId);
    List<ResumeListResponseDto> getIsAppliedResumeList(Long memberId);
}
