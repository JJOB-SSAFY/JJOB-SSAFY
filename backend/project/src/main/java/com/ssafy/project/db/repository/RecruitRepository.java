package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitRepository extends JpaRepository<Recruit, Long> {
}
