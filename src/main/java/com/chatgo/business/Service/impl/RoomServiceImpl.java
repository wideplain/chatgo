package com.chatgo.business.Service.impl;

import com.chatgo.business.Service.RoomService;
import com.chatgo.business.entitiy.Room;
import com.chatgo.business.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }
}
