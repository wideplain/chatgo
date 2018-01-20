package com.chatgo.business.Service;

import com.chatgo.business.dto.RoomDto;
import com.chatgo.business.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoomService {
    void save(Room room);

    Page<Room> findAll(Pageable pageable);

    List<Room> findAllByNameLike(String keyword);
}
