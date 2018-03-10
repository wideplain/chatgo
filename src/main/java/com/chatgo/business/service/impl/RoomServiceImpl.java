package com.chatgo.business.service.impl;


import com.chatgo.business.entity.RoomUser;
import com.chatgo.business.service.RoomService;
import com.chatgo.business.dto.RoomDto;
import com.chatgo.business.entity.Room;
import com.chatgo.business.repository.RoomRepository;
import com.chatgo.business.service.RoomUserService;
import com.chatgo.security.LoginUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomUserService roomUserService;

    @Autowired
    private RoomService roomService;


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
    public List<Room> findAll() {
        return roomRepository.findAll();
    }


    @Override
    public List<Room> findAllByNameLike(String keyword) {
            return roomRepository.findAllByNameLike("%" + keyword + "%");
    }

    public List<Room> ifUserSignIn(@AuthenticationPrincipal LoginUserDetails loginUserDetails, Pageable pageable, Model model) {
        if (loginUserDetails == null) {
            List<Room> rooms = roomService.findAll();
            return rooms;
        } else {
            List<RoomUser> roomsUser = roomUserService.findAllByUserId(loginUserDetails.getUserId());
            List<Room> rooms = new ArrayList<Room>();
            for (int i = 0; i < roomsUser.size(); i++) {
                RoomUser roomUser = roomsUser.get(i);
                Room room = roomUser.getRoom();
                rooms.add(room);
            }
            return rooms;
        }
    }


}
