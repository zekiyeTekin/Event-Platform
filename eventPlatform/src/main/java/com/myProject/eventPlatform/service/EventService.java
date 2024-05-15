package com.myProject.eventPlatform.service;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.entity.Event;

import java.util.List;

public interface EventService {

    ResponseModel<List<Event>> getAll();

    ResponseModel<Event> create(Event event);
    ResponseModel<Event> updateTitle(Event event);

    ResponseModel<Event> delete(Event event);

    ResponseModel<List<Event>> listEventByCategory(Event event);

}
