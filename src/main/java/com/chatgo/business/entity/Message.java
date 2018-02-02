package com.chatgo.business.entity;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {

    @ManyToOne
    private User user;

    @ManyToOne
    private Room room;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String body;

    private Timestamp updatedAt;

    @Column(updatable=false)
    private Timestamp createdAt;

    @PrePersist
    public void prePersist() {
        Timestamp ts = new Timestamp((new Date()).getTime());
        this.createdAt = ts;
        this.updatedAt = ts;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Timestamp((new Date()).getTime());
    }


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
