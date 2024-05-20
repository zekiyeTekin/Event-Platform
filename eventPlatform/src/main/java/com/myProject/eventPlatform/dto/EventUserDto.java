package com.myProject.eventPlatform.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myProject.eventPlatform.entity.Event;
import com.myProject.eventPlatform.entity.Role;
import com.myProject.eventPlatform.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventUserDto {

    private Integer id;

    private Integer roleId;

    private Integer eventId;

    private Integer userId;


}
