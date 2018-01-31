package com.chatgo.business.service;

import com.chatgo.business.entity.Message;

import java.util.List;

public interface MessageService {
    void save(Message message, Long roomId, Long userId);

    List<Message> findAllByRoomId(Long roomId);
}
