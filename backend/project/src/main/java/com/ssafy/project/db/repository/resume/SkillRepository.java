package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Resume;
import com.ssafy.project.db.entity.resume.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findAllByResumeId(Long resumeId);

    Optional<Skill> findByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
