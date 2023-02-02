package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.ProjectExp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectExpRepository extends JpaRepository<ProjectExp, Long> {
    List<ProjectExp> findAllByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
