package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    List<Certificate> findAllByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
