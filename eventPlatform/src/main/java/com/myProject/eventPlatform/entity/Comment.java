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

    private String type;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "community_id", nullable = false)
    private Community community;

    @ManyToOne // bunu yapmamın sebebi birden cok yorum tek etkinliğe atılması için
    @JoinColumn(name = "event_id")
    private Event event;

    private Boolean isDeleted;



}
