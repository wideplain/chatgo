package com.chatgo.business.entity;


import javax.persistence.*;

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


}
