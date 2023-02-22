package com.ssafy.project.api.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoomRequestDto {
    private Long roomNumber;
    private String title;
}