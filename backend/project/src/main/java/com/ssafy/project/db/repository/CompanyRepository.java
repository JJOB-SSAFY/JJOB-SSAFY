package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
