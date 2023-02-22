package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.ConferenceEnum;
import com.ssafy.project.db.entity.MemberConference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberConferenceRepository extends JpaRepository<MemberConference, Long> {

    void deleteAllByConferenceId(Long id);

    List<MemberConference> findAllByMemberEmailAndConference_conferenceCategoryOrderByConference_callStartTimeDesc(String email, ConferenceEnum valueOf);
}
