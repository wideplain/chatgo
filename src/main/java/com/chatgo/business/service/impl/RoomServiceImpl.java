package com.chatgo.business.service.impl;

import com.chatgo.business.service.RoomService;
import com.chatgo.business.dto.RoomDto;
import com.chatgo.business.entity.Room;
import com.chatgo.business.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    private RoomDto roomDto;

    @Override
    public Room findOne(Long id){
        return roomRepository.findOne(id);
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public Page<Room> findAll(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }


    @Override
    public List<Room> findAllByNameLike(String keyword) {
            return roomRepository.findAllByNameLike("%" + keyword + "%");
    }


}
