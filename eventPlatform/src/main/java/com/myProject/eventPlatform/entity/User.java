package com.myProject.eventPlatform.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;
    private Integer phoneNumber;
    private String mail;
    private Integer age;
    private String visibility;
    private String location;
    private String password;
    private Boolean isActive;


    //@OneToMany(mappedBy = "user") // burada eğer bir kullanıcıların katıldığı tüm etkinlikleri görmek istersem diye
    //private List<EventUser> eventsAttended;




}
