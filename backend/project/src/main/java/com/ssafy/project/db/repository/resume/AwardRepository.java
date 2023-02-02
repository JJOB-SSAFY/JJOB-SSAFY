package com.ssafy.project.db.repository.resume;


import com.ssafy.project.db.entity.resume.Award;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AwardRepository extends JpaRepository<Award, Long> {
    List<Award> findAllByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
