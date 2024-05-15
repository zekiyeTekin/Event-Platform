package com.myProject.eventPlatform.entity;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
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
    private String message_sender;
    private String message_receive;
    private LocalDate date;
    private Boolean isDeleted;


}
