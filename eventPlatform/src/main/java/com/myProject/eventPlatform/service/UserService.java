package com.myProject.eventPlatform.service;

import com.myProject.eventPlatform.dto.UserDto;
import com.myProject.eventPlatform.common.ResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseModel<List<UserDto>> getAllUsers();

    ResponseModel<List<UserDto>> getUsersByActiveState();

    ResponseModel<UserDto> save(UserDto userDto);

    ResponseModel<UserDto> updateMail(UserDto userDto);

    ResponseModel<UserDto> delete(UserDto userDto);



}
