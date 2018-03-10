package com.chatgo.business.service.impl;

import com.chatgo.business.entity.Message;
import com.chatgo.business.repository.MessageRepository;
import com.chatgo.business.service.MessageService;
import com.chatgo.business.service.RoomService;
import com.chatgo.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @Override
    public void save(Message message, Long userId, Long roomId) {
        message.setRoom(roomService.findOne(roomId));
        message.setUser(userService.findOne(userId));
        messageRepository.save(message);
    }


    @Override
    public Page<Message> findAll(Pageable pageable) {
        return messageRepository.findAll(pageable);
    }


    @Override
    public List<Message> findAllByRoomId(Long roomId, Pageable pageable) {
        return messageRepository.findAllByRoomId(roomId, pageable);
    }


}
