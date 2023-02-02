package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Long> {
    List<University> findAllByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
