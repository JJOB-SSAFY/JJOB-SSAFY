package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ResumeRepository extends JpaRepository<Resume, Long> {
    List<Resume> findAllByMemberEmail(String email);
    void deleteById(Long resumeId);
}
