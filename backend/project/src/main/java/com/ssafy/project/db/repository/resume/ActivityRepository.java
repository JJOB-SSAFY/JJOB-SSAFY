package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Activity;
import com.ssafy.project.db.entity.resume.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAllByResumeId(Long resumeId);
    Optional<Activity> findByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
