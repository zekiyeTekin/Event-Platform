package com.myProject.eventPlatform.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
