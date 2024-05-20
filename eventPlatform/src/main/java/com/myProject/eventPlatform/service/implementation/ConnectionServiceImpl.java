package com.myProject.eventPlatform.service.implementation;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.ConnectionDto;
import com.myProject.eventPlatform.entity.Connection;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseMessageEnum;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseStatusEnum;
import com.myProject.eventPlatform.mapper.ConnectionMapper;
import com.myProject.eventPlatform.mapper.UserMapper;
import com.myProject.eventPlatform.repository.ConnectionRepository;
import com.myProject.eventPlatform.service.ConnectionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    private final ConnectionRepository connectionRepository;
    private final ConnectionMapper connectionMapper;
    public ConnectionServiceImpl(ConnectionRepository connectionRepository, ConnectionMapper connectionMapper){
        this.connectionRepository = connectionRepository;
        this.connectionMapper = connectionMapper;
    }

    public ResponseModel<List<ConnectionDto>> getAll(){
        List<Connection> connectionList = connectionRepository.findAll();
        try{
            if(connectionList.isEmpty()){
                return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), true, ResponseMessageEnum.DATA_NOT_FOUND, null);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.CREATED_SUCCESSFULLY, connectionMapper.convertList(connectionList));
    }

    public ResponseModel<ConnectionDto> sendConnectionRequest(Connection connection) {
        Connection connectionRequest = new Connection();

        connectionRequest.setSender(connection.getSender());
        connectionRequest.setReceiver(connection.getReceiver());
        connectionRequest.setDate(LocalDate.now());
        connectionRequest.setStatus(false);
        connectionRepository.save(connectionRequest);
        Connection savedConnection =connectionRepository.save(connectionRequest);

        return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.CREATED_SUCCESSFULLY, connectionMapper.toDto(savedConnection));
    }

    public ResponseModel<ConnectionDto> acceptedConnection(ConnectionDto connectionDto){

        Connection connectionRequest = connectionRepository.findById(connectionDto.getId()).orElse(null);
        if(connectionRequest != null){
            if (!connectionRequest.getStatus()) {// && connection.getReceiver().getIsActive()

                connectionRequest.setStatus(true);
                Connection savedConnectionRequest = connectionRepository.save(connectionRequest);
                return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.CONNECTION_ACCEPTED, connectionMapper.toDto(savedConnectionRequest));
            }else {
                return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum. CONNECTION_ALREADY_ACCEPT, null);
            }
        }else{
            return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
        }
    }


    public ResponseModel<ConnectionDto> rejectConnection(Connection connection){

        Connection connectionRequest = connectionRepository.findById(connection.getId()).orElse(null);
        if(connectionRequest != null){
            if(!connectionRequest.getStatus()){
                connectionRequest.setStatus(null);
                Connection savedForDeletedConnection =connectionRepository.save(connectionRequest);
                connectionRepository.delete(savedForDeletedConnection);
                return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum. CONNECTION_REJECT, connectionMapper.toDto(savedForDeletedConnection));
            }else{
                return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.CONNECTION_ACCEPT_ERROR, null);
            }
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
    }



    public ResponseModel<List<ConnectionDto>> listConnectionWhenStatusFalse(Connection connection){

        List<Connection> receiverConnections = connectionRepository.findConnectionsByReceiver(connection.getReceiver());

        List<Connection> statusFalseConnection = receiverConnections.stream()
                .filter(receiverConnection -> receiverConnection.getStatus() != null && !receiverConnection.getStatus())
                .collect(Collectors.toList());

        return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE, connectionMapper.convertList(statusFalseConnection));
    }

    public ResponseModel<List<ConnectionDto>> getUserConnection(Integer receiverId){
        List<Connection> userConnections = connectionRepository.findConnectionsByReceiverId(receiverId);
        return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE, connectionMapper.convertList(userConnections));

    }









}
