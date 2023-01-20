package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<Career, Long> {
}
