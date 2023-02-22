package com.ssafy.project.api.service;

import com.ssafy.project.db.entity.Message;
import com.ssafy.project.db.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public void insertMessage(Message chatMessage) {
        messageRepository.save(chatMessage);
    }

    @Override
    public List<Message> getMessagesByChatroomNumber(Long roomNumber) {
        PageRequest pageRequest = PageRequest.of(0, 10);
        return messageRepository.findAllByRoomNumber(roomNumber, pageRequest);
    }
}