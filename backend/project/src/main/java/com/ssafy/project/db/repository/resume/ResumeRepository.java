package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
