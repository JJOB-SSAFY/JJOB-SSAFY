package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Career;
import com.ssafy.project.db.entity.resume.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    List<Certificate> findAllByResumeId(Long resumeId);
    Optional<Certificate> findByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
