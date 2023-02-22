package com.ssafy.project.db.entity;

import com.ssafy.project.api.request.ChatRoomRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatroom_id")
    private Long id;
    @Column(unique = true)
    private Long roomNumber;
    private String title;
    private String masterEmail;

    public static ChatRoom from(ChatRoomRequestDto requestDto, String email) {
        return ChatRoom.builder()
                .roomNumber(requestDto.getRoomNumber())
                .title(requestDto.getTitle())
                .masterEmail(email)
                .build();
    }

}