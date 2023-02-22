package com.ssafy.project.api.service;

import com.ssafy.project.db.entity.Message;

import java.util.List;

public interface MessageService {
    void insertMessage(Message chatMessage);
    List<Message> getMessagesByChatroomNumber(Long roomNumber);
}