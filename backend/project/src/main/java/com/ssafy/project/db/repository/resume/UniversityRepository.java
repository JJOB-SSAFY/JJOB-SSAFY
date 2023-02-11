package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Skill;
import com.ssafy.project.db.entity.resume.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University, Long> {
    List<University> findAllByResumeId(Long resumeId);

    Optional<University> findByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
