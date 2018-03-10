package com.chatgo.business.service;

import com.chatgo.business.entity.RoomUser;

import java.awt.print.Pageable;
import java.util.List;

public interface RoomUserService {

    void save(RoomUser roomUser, Long roomId, Long userId);

    List<RoomUser> findAllByUserId(Long userId);

}
