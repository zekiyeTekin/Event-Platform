package com.myProject.eventPlatform.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "connection")
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sender_user_id" ,referencedColumnName = "id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_user_id" ,referencedColumnName = "id")
    private User receiver;

    private Boolean status;
    //eğer status null ise istek yoktur ve connection tablosunda yer almaz.
    //eğer status false ise bağlantı isteği atılmıştır. ve statusun ya null ya da true olmasını bekler.
    //eğer status true ise bağlantı isteği kabul edilmiştir.
    //istek gönderildiğinde statusun

    private LocalDate date;

    //@ManyToOne
    //@JoinColumn(name = "user_id" ,referencedColumnName = "id")
    //private User user;

}
// 1To2 2. oraya ekleyeceğim private olan şeyi temsil eder
// 1 ise genel classı ifade eder
