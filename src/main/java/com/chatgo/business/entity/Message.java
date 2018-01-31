package com.chatgo.business.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "messages")
public class Message extends TimestampEntity {

    @ManyToOne
    private User user;

    @ManyToOne
    private Room room;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String body;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


}
