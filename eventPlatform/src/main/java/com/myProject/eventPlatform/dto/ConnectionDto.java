package com.myProject.eventPlatform.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConnectionDto {

    private Integer id;

    private UserDto sender;
    private UserDto receiver;
    private Boolean status;
    private LocalDate date;

}
