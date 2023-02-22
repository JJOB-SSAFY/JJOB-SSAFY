package com.ssafy.project.api.service;

import com.ssafy.project.api.request.ChatRoomRequestDto;
import com.ssafy.project.db.entity.ChatRoom;
import com.ssafy.project.db.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    @Override
    public void createRoom(String email, ChatRoomRequestDto requestDto) {
        ChatRoom chatRoom = ChatRoom.from(requestDto, email);
        chatRoomRepository.save(chatRoom);
    }

    @Override
    public List<ChatRoom> getAllChatRooms() {
        return chatRoomRepository.findAll();
    }

    @Override
    public String getRoomTitle(Long roomNumber) {
        ChatRoom chatRoom = chatRoomRepository.findByRoomNumber(roomNumber).orElseThrow(NullPointerException::new);
        return chatRoom.getTitle();
    }

}