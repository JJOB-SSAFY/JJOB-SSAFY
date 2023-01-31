package com.ssafy.project.api.service;

import com.ssafy.project.api.response.ResumeListResponseDto;
import com.ssafy.project.db.entity.Member;

import java.util.List;

public interface ResumeService {
    List<ResumeListResponseDto> getResumeList(String email);
}
