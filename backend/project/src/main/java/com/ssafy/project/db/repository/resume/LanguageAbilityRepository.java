package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.LanguageAbility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageAbilityRepository extends JpaRepository<LanguageAbility, Long> {
    List<LanguageAbility> findAllByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);

}
