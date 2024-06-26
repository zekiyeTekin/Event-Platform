package com.myProject.eventPlatform.mapper;

import com.myProject.eventPlatform.dto.UserDto;
import com.myProject.eventPlatform.dto.forCommentDto.UserDtoForComment;
import com.myProject.eventPlatform.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserMapper {




    public UserDto toDto(User user){

        return new UserDto.Builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .location(user.getLocation())
                .mail(user.getMail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .visibility(user.getVisibility())
                .isActive(user.getIsActive())
                .build();
    }

    public List<UserDto> convertList (List<User> userList){
        List<UserDto> userDtoList = new ArrayList<>();
        for( User user : userList){
            userDtoList.add(toDto(user));
        }
        return userDtoList;
    }

    public User toEntity(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setLocation(userDto.getLocation());
        user.setPassword(userDto.getPassword());
        user.setVisibility(userDto.getVisibility());
        user.setMail(userDto.getMail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setIsActive(userDto.getIsActive());
        user.setAge(userDto.getAge());
        user.setRole(userDto.getRole());
        return user;
    }

    public UserDtoForComment toDtoForComment(User user){
        return UserDtoForComment.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }




}




