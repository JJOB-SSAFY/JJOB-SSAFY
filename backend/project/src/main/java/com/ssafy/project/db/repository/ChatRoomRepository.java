package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    Optional<ChatRoom> findByRoomNumber(Long roomNumber);
}