package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findAllByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
