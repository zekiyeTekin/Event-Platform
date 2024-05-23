package com.myProject.eventPlatform.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String content;
    private LocalDate date;
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "sender_user_id" ,referencedColumnName = "id")
    private User message_sender;

    @ManyToOne
    @JoinColumn(name = "receiver_user_id" ,referencedColumnName = "id")
    private User message_receiver;



}
