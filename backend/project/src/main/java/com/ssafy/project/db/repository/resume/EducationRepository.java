package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.CoverLetter;
import com.ssafy.project.db.entity.resume.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findAllByResumeId(Long resumeId);
    Optional<Education> findByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
