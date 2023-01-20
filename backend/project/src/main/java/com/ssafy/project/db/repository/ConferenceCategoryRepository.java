package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.ConferenceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceCategoryRepository extends JpaRepository<ConferenceCategory, Long> {
}
