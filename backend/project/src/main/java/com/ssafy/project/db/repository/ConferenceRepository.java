package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
