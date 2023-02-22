package com.ssafy.project.api.service;

import com.ssafy.project.api.request.ChatRoomRequestDto;
import com.ssafy.project.db.entity.ChatRoom;

import java.util.List;

public interface ChatRoomService {
    void createRoom(String email, ChatRoomRequestDto requestDto);
    List<ChatRoom> getAllChatRooms();
    String getRoomTitle(Long roomNumber);
}