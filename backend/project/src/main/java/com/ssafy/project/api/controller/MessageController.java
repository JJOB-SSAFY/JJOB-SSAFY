package com.ssafy.project.api.controller;

import com.ssafy.project.api.service.MessageService;
import com.ssafy.project.db.entity.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MessageController {
    private final MessageService messageService;
    private final SimpMessagingTemplate template;

    @MessageMapping("/message")
    public void sendMessage(@Payload Message chatMessage) {
        log.info("전달 메세지 : " + chatMessage);

        messageService.insertMessage(chatMessage);
        template.convertAndSend("/sub/" + chatMessage.getRoomNumber(), chatMessage);
    }
}