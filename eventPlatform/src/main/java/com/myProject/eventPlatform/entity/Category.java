package com.myProject.eventPlatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myProject.eventPlatform.enumuration.category.TypeEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    //enum olarak tuttum
    private TypeEnum type;

    private Boolean isActive;



}

