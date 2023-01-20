package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
