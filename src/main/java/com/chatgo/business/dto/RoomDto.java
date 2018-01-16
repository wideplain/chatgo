package com.chatgo.business.dto;


import com.chatgo.business.entitiy.Room;
import com.chatgo.business.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class RoomDto {

    @Autowired
    private RoomRepository roomRepository;

    public Page<Room> findAll(Pageable pageable) {
        Page<Room> roomDto = roomRepository.findAll(pageable);
    }

}