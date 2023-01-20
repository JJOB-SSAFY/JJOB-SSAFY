package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
