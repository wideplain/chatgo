package com.chatgo.business.service;

import com.chatgo.business.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MessageService {
    void save(Message message, Long roomId, Long userId);

    Page<Message> findAll(Pageable pageable);

    List<Message> findAllByRoomId(Long roomId, Pageable pageable);


}
