package com.ssafy.project.api.controller;

import com.ssafy.project.api.request.ChatRoomRequestDto;
import com.ssafy.project.api.response.BaseResponseBody;
import com.ssafy.project.api.service.ChatRoomService;
import com.ssafy.project.api.service.ChatRoomServiceImpl;
import com.ssafy.project.api.service.MessageService;
import com.ssafy.project.common.auth.SsafyUserDetails;
import com.ssafy.project.db.entity.ChatRoom;
import com.ssafy.project.db.entity.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@RestController
public class ChatRoomController {

    private final ChatRoomService chatroomService;
    private final MessageService messageService;
    final int PAGE = 10;

    // 특정 채팅방 타이틀 가져오기
    @GetMapping("/room/{room_number}")
    public ResponseEntity<BaseResponseBody> roomTitle(@PathVariable Long room_number) {

        return new ResponseEntity<>(new BaseResponseBody(chatroomService.getRoomTitle(room_number), 200), HttpStatus.OK);
    }

    // 모든 채팅방 목록 반환
    @GetMapping("/rooms")
    public ResponseEntity<List<ChatRoom>> room() {
        List<ChatRoom> rooms = chatroomService.getAllChatRooms();
        if (rooms == null || rooms.size() == 0)
            return ResponseEntity.status(HttpStatus.OK).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(rooms);

    }

    // 방 생성
    @PostMapping("/room")
    public ResponseEntity<BaseResponseBody> createRoom(@AuthenticationPrincipal SsafyUserDetails userDetails,
                                                       @RequestBody ChatRoomRequestDto requestDto) {
        chatroomService.createRoom(userDetails.getEmail(), requestDto);
        return new ResponseEntity<>(new BaseResponseBody("Success", 201), HttpStatus.CREATED);
    }

    // 특정 채팅방 의 메세지 최근 10개
    @GetMapping("/room/message/{room_number}")
    public ResponseEntity<List<Message>> roomInfo(@PathVariable Long room_number,
                                                  @RequestParam(value = "page", defaultValue = "0") String page) {
//        long idx = page.equals("0") ? 0 : Integer.parseInt(page) * PAGE + 1;
        List<Message> msgList = messageService.getMessagesByChatroomNumber(room_number);
        return ResponseEntity.status(HttpStatus.OK).body(msgList);
    }

}