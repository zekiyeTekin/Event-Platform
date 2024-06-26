package com.myProject.eventPlatform.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDto {

    private Integer id;

    private String title;
    private String address;
    private LocalDate date;
    private String details;
    private Boolean isActive;

    private CategoryDto category;


    private CommunityDto community;


}
