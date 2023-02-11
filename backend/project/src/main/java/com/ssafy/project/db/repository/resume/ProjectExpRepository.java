package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.LanguageAbility;
import com.ssafy.project.db.entity.resume.ProjectExp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectExpRepository extends JpaRepository<ProjectExp, Long> {
    List<ProjectExp> findAllByResumeId(Long resumeId);

    Optional<ProjectExp> findByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
