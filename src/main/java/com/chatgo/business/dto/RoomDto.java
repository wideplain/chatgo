package com.chatgo.business.dto;

import com.chatgo.business.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomDto {

    @Autowired
    private RoomRepository roomRepository;

    public String findOneOrNew(String name) {
        return name;
    }

}
