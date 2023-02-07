package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.ConferenceEnum;
import com.ssafy.project.db.entity.MemberConference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberConferenceRepository extends JpaRepository<MemberConference, Long> {
    List<MemberConference> findAllByMemberIdAndConference_conferenceCategoryOrderByConference_callStartTimeDesc(Long member_id, ConferenceEnum conference_conferenceCategory);

    void deleteAllByConferenceId(Long id);
}
