package com.chatgo.business.dto;


import com.chatgo.business.entity.Room;
import com.chatgo.business.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class RoomDto {

    @Autowired
    private RoomRepository roomRepository;


}