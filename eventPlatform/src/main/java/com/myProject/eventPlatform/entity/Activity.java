package com.myProject.eventPlatform.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private Enum type;
    private LocalDate date;

    @ManyToOne  // her bir Activity kaydı bir usera ait
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne // her bir Activity kaydı bir etkinliğe ait
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    private Boolean isDeleted;

}
