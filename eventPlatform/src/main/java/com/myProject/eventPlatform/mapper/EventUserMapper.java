package com.myProject.eventPlatform.mapper;

import com.myProject.eventPlatform.dto.ConnectionDto;
import com.myProject.eventPlatform.dto.EventUserDto;
import com.myProject.eventPlatform.entity.Connection;
import com.myProject.eventPlatform.entity.EventUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventUserMapper {


    public EventUserDto toDto(EventUser eventUser){
        return EventUserDto.builder()
                .id(eventUser.getId())
                .eventId(eventUser.getEvent().getId())
                .userId(eventUser.getUser().getId())
                .roleId(eventUser.getId())
                .build();
    }

    public List<EventUserDto> convertList(List<EventUser> eventUserList){
        List<EventUserDto> eventUserDtoList = new ArrayList<>();
        for (EventUser eventUser : eventUserList){
            eventUserDtoList.add(toDto(eventUser));
        }
        return eventUserDtoList;
    }



}
