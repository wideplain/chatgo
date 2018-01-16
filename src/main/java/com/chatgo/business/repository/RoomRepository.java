package com.chatgo.business.repository;

import com.chatgo.business.entitiy.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository <Room, Long>{

}
