package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
