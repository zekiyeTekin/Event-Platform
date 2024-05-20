package com.myProject.eventPlatform.service;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.EventUserDto;
import com.myProject.eventPlatform.entity.EventUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EventUserService {

    ResponseModel<List<EventUserDto>> getAll();

    ResponseModel<EventUserDto> getById(Integer id);

    ResponseModel<EventUserDto> add(EventUser eventUser);

    ResponseModel<List<EventUserDto>> getEventUsersByEvent(Integer id);



}

