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

    ResponseModel<Event> delete(Event event);

    ResponseModel<List<Event>> listEventByCategory(Event event);

    ResponseModel<List<Event>> searchByDateWithFilter(EventFilter eventFilter);

    ResponseModel<List<Event>> searchByCategoryTypeWithFilter(EventFilter eventFilter);

    ResponseModel<List<Event>> searchByAddressWithFilter(EventFilter eventFilter);

}
