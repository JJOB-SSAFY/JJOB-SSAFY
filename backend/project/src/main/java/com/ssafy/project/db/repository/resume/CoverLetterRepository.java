package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Certificate;
import com.ssafy.project.db.entity.resume.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CoverLetterRepository extends JpaRepository<CoverLetter, Long> {
    List<CoverLetter> findAllByResumeId(Long resumeId);
    Optional<CoverLetter> findByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
