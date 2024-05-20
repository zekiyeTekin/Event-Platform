package com.myProject.eventPlatform.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myProject.eventPlatform.entity.Community;
import com.myProject.eventPlatform.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommunityUserDto {


    private Integer id;

    private CommunityDto community;

    private UserDto user;

    private Boolean isActive;
}
