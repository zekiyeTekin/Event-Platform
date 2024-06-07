package com.myProject.eventPlatform.dto;

import com.myProject.eventPlatform.enumuration.role.RoleEnum;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private Integer id;

    private RoleEnum name;

}
