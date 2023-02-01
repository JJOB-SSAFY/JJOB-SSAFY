package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.MemberConference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberConferenceRepository extends JpaRepository<MemberConference, Long> {
    List<MemberConference> findAllByMemberId(long memberId);

    void deleteAllByConferenceId(Long id);
}
