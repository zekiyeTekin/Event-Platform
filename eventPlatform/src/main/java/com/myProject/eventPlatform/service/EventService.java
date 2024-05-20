package com.myProject.eventPlatform.service;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.EventDto;
import com.myProject.eventPlatform.entity.Event;
import com.myProject.eventPlatform.filter.EventFilter;

import java.util.List;

public interface EventService {

    ResponseModel<List<EventDto>> getAll();

    ResponseModel<EventDto> create(Event event);
    ResponseModel<EventDto> updateTitle(Event event);

    ResponseModel<EventDto> delete(Event event);

    ResponseModel<List<EventDto>> listEventByCategory(Event event);

    ResponseModel<List<EventDto>> searchByDateWithFilter(EventFilter eventFilter);

    ResponseModel<List<EventDto>> searchByCategoryTypeWithFilter(EventFilter eventFilter);

    ResponseModel<List<EventDto>> searchByAddressWithFilter(EventFilter eventFilter);

    ResponseModel<List<EventDto>> searchByCommunityWithFilter(EventFilter eventFilter);

}
