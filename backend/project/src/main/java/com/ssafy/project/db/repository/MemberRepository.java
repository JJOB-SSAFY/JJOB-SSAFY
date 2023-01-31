package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
