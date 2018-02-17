package com.chatgo.business.entity;

import java.sql.Timestamp;

public class SocketMessage {

    private  String socketMessage;

    private Message message;

    private Long userId;

    private Long roomId;


    public SocketMessage(String socketMessage) {
        this.socketMessage = socketMessage;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
