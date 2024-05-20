package com.myProject.eventPlatform.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "community_users")
public class CommunityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "community_id", referencedColumnName = "id")
    private Community community;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    private Boolean isActive;
}
