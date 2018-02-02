package com.chatgo.business.service;

import com.chatgo.business.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface RoomService {

    void save(Room room);

    Room findOne(Long id);

    Page<Room> findAll(Pageable pageable);

    List<Room> findAllByNameLike(String keyword);
}
