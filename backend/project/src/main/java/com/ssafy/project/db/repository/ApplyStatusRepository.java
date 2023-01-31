package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.ApplyStatus;
import com.ssafy.project.db.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplyStatusRepository extends JpaRepository<ApplyStatus, Long> {
}
