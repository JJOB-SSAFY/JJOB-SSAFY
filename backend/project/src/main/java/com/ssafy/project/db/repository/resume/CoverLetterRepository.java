package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoverLetterRepository extends JpaRepository<CoverLetter, Long> {
    List<CoverLetter> findAllByResumeId(Long resumeId);
    void deleteAllByResumeId(Long resumeId);
}
