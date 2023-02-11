package com.ssafy.project.db.repository.resume;


import com.ssafy.project.db.entity.resume.Activity;
import com.ssafy.project.db.entity.resume.Award;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AwardRepository extends JpaRepository<Award, Long> {
    List<Award> findAllByResumeId(Long resumeId);
    Optional<Award> findByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
