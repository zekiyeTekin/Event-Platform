package com.myProject.eventPlatform.entity;


import com.myProject.eventPlatform.enumuration.role.RoleEnum;
import com.myProject.eventPlatform.enumuration.role.TypeEnum;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
@Entity
@Table(name = "event_users")
public class EventUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    @ManyToOne //Bir etkinlikte birden fazla katılımcı olabilir
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
