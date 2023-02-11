package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Education;
import com.ssafy.project.db.entity.resume.LanguageAbility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LanguageAbilityRepository extends JpaRepository<LanguageAbility, Long> {
    List<LanguageAbility> findAllByResumeId(Long resumeId);

    Optional<LanguageAbility> findByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);

}
