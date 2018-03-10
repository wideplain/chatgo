package com.chatgo.business.dto;


import com.chatgo.business.entity.Room;
import com.chatgo.business.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class RoomDto {
    private String body;
    private Long roomId;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "RoomDto{" +
                "body='" + body + '\'' +
                ", roomId=" + roomId +
                '}';
    }
}