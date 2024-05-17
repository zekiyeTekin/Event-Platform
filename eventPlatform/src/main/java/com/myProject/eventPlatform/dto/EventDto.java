package com.myProject.eventPlatform.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myProject.eventPlatform.entity.Category;
import com.myProject.eventPlatform.entity.Comment;
import com.myProject.eventPlatform.entity.Community;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
