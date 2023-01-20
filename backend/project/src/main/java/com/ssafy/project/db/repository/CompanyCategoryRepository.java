package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.CompanyCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyCategoryRepository extends JpaRepository<CompanyCategory, Long> {
}
