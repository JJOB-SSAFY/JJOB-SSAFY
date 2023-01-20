package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
