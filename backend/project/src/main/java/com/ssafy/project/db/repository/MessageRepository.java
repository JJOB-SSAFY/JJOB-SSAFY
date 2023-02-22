package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByRoomNumber(Long chatRoomId, Pageable pageable);
}