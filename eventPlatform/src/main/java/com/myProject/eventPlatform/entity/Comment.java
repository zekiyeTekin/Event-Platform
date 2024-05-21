package com.myProject.eventPlatform.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String type; //enum olarak tutulabilir
    private LocalDate date;

    private String content;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Yorumun sahibi kullanıcı

    @ManyToOne // tek etkinliğin çok yorumu olmalı
    @JoinColumn(name = "event_id")
    private Event event;

    private Boolean isDeleted;

}
