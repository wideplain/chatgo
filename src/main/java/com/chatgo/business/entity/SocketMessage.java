package com.chatgo.business.entity;

import java.sql.Timestamp;

public class SocketMessage {


    private String message;

    private String username;

    private String createdAt;

    private Long userId;

    public SocketMessage() {

    }

    public SocketMessage(String message, String username, String createdAt, Long userId) {
        this.message = message;
        this.username = username;
        this.createdAt = createdAt;
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Long getUserId() {
        return userId;
    }
}
