package com.chatgo.business.Service;

import com.chatgo.business.entitiy.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoomService {
    void save(Room room);

    Room findOneOrNew(String name);
    Page<Room> findAll(Pageable pageable);
}
