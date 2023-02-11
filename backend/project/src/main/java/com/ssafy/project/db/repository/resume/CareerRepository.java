package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Award;
import com.ssafy.project.db.entity.resume.Career;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CareerRepository extends JpaRepository<Career, Long> {
    List<Career> findAllByResumeId(Long resumeId);
    Optional<Career> findByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
