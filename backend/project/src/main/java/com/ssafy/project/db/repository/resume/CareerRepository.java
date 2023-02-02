package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Career;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CareerRepository extends JpaRepository<Career, Long> {
    List<Career> findAllByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
