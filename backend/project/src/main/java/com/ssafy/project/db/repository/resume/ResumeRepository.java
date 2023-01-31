package com.ssafy.project.db.repository.resume;

import com.ssafy.project.db.entity.resume.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    @Query("select r from Resume r join Member m where r.member.email = :email")
    List<Resume> findAllByMember(@Param("email") String email);

    List<Resume> findAllByMemberEmail(String email);
}
