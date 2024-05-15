package com.myProject.eventPlatform.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "communities")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String title;
    private String details;

    private String address;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Boolean isActive;
}
