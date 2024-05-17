package com.myProject.eventPlatform.mapper;

import com.myProject.eventPlatform.dto.EventDto;
import com.myProject.eventPlatform.entity.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventMapper {

    private final CategoryMapper categoryMapper;
    private final CommunityMapper communityMapper;
    public EventMapper(CategoryMapper categoryMapper, CommunityMapper communityMapper){
        this.categoryMapper = categoryMapper;
        this.communityMapper = communityMapper;
    }

    public EventDto toDto(Event event){
        return EventDto.builder()
                .id(event.getId())
                .address(event.getAddress())
                .date(event.getDate())
                .title(event.getTitle())
                .details(event.getDetails())
                .isActive(event.getIsActive())
                .category(categoryMapper.toDto(event.getCategory()))
                .community(communityMapper.toDto(event.getCommunity()))
                .build();
    }

    public List<EventDto> convertList(List<Event> eventList){
        List<EventDto> eventDtoList = new ArrayList<>();

        for(Event event : eventList){
            eventDtoList.add(toDto(event));
        }
        return eventDtoList;
    }




}
