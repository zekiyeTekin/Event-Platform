package com.myProject.eventPlatform.service;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.controller.ConnectionController;
import com.myProject.eventPlatform.dto.ConnectionDto;
import com.myProject.eventPlatform.entity.Connection;
import com.myProject.eventPlatform.entity.User;
import com.myProject.eventPlatform.filter.ConnectionFilter;

import java.util.List;

public interface ConnectionService {

    ResponseModel<List<ConnectionDto>> getAll();

    ResponseModel<ConnectionDto>  sendConnectionRequest(Connection connection);

    ResponseModel<ConnectionDto> acceptedConnection(ConnectionDto connectionDto);

    ResponseModel<ConnectionDto> rejectConnection(Connection connection);

    ResponseModel<List<ConnectionDto>> listConnectionWhenStatusFalse(Connection connection);

    ResponseModel<List<ConnectionDto>> getUserConnection(Integer receiverId);

    ResponseModel<List<ConnectionDto>> listConnectionWhenStatusFalseWithFilter(ConnectionFilter connectionFilter);

}
