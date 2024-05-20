package com.myProject.eventPlatform.service.implementation;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.EventUserDto;
import com.myProject.eventPlatform.entity.EventUser;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseMessageEnum;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseStatusEnum;
import com.myProject.eventPlatform.mapper.EventUserMapper;
import com.myProject.eventPlatform.repository.EventUserRepository;
import com.myProject.eventPlatform.service.EventUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventUserServiceImpl implements EventUserService {

    private final EventUserRepository eventUserRepository;
    private final EventUserMapper eventUserMapper;
    public EventUserServiceImpl(EventUserRepository eventUserRepository, EventUserMapper eventUserMapper) {
        this.eventUserRepository = eventUserRepository;
        this.eventUserMapper = eventUserMapper;
    }

    public ResponseModel<List<EventUserDto>> getAll(){
        List<EventUser> eventUsers = eventUserRepository.findAll();
        if (!eventUsers.isEmpty()){
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE, eventUserMapper.convertList(eventUsers));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
    }

    public ResponseModel<EventUserDto> getById(Integer id){
        EventUser eventUser = eventUserRepository.findById(id).orElse(null);
        if( eventUser != null ){
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.SUCCESSFULLY_DONE, eventUserMapper.toDto(eventUser));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
    }

    public ResponseModel<EventUserDto> add(EventUser eventUser){
        try{
            EventUser newEventUser = eventUserRepository.save(eventUser);
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.CREATED_SUCCESSFULLY, eventUserMapper.toDto(newEventUser));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.CREATED_ERROR, null);
    }

    public ResponseModel<List<EventUserDto>> getEventUsersByEvent(Integer id){
            List<EventUser> eventUserList = eventUserRepository.findEventUsersByEvent_Id(id);
            if( eventUserList != null ){
                return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.CREATED_SUCCESSFULLY, eventUserMapper.convertList(eventUserList));
            }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.CREATED_ERROR, null);
    }




}
