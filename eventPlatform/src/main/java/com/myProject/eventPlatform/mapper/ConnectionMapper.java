package com.myProject.eventPlatform.mapper;

import com.myProject.eventPlatform.dto.ConnectionDto;
import com.myProject.eventPlatform.dto.UserDto;
import com.myProject.eventPlatform.entity.Connection;
import com.myProject.eventPlatform.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConnectionMapper {

    private final UserMapper userMapper;
    public ConnectionMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }


    public ConnectionDto toDto(Connection connection){
        return ConnectionDto.builder()
                .id(connection.getId())
                .sender(userMapper.toDto(connection.getSender()))
                .receiver(userMapper.toDto(connection.getReceiver()))
                .status(connection.getStatus())
                .date(connection.getDate())
                .build();
    }

    public List<ConnectionDto> convertList(List<Connection> connectionList){
        List<ConnectionDto> connectionDtoList = new ArrayList<>();
        for (Connection connection : connectionList){
            connectionDtoList.add(toDto(connection));
        }
        return connectionDtoList;
    }


    public Connection toEntity(ConnectionDto connectionDto){
        Connection connection = new Connection();

        connection.setStatus(connectionDto.getStatus());
        connection.setDate(connectionDto.getDate());
        connection.setSender(userMapper.toEntity(connectionDto.getSender()));
        connection.setReceiver(userMapper.toEntity(connectionDto.getReceiver()));
        connection.setId(connectionDto.getId());
        return connection;
    }



}
