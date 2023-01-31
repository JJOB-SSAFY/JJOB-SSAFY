package com.ssafy.project.api.service;

import com.ssafy.project.api.response.ResumeListResponseDto;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.entity.resume.Resume;
import com.ssafy.project.db.repository.resume.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("resumeService")
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;

    @Override
    public List<ResumeListResponseDto> getResumeList(String email) {
        List<Resume> list = resumeRepository.findAllByMember(email);

        //List<ResumeListResponseDto> collect = list.stream().map((o) -> new ResumeListResponseDto(o)).collect(Collectors.toList());
        List<ResumeListResponseDto> result = list.stream().map(ResumeListResponseDto::new).collect(Collectors.toList());
        return result;
    }
}
