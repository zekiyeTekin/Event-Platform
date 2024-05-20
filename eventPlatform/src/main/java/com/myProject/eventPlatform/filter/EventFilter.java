package com.myProject.eventPlatform.filter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myProject.eventPlatform.enumuration.category.TypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EventFilter {

    private TypeEnum category;
    private String community;
    private String address;
    private String title; //yap

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

}
