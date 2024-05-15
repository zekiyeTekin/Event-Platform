package com.myProject.eventPlatform.service.implementation;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.entity.Event;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseMessageEnum;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseStatusEnum;
import com.myProject.eventPlatform.repository.EventRepository;
import com.myProject.eventPlatform.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    public EventServiceImpl(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public ResponseModel<List<Event>> getAll(){
        try {
            List<Event> eventList = eventRepository.findAll();

            if(!eventList.isEmpty()){
                return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE, eventList);
            }
        }catch (Exception e){
            e.printStackTrace();
            }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND,null);
    }

    public ResponseModel<Event> create(Event event){
        try {
            Event newEvent = eventRepository.save(event);
            return new ResponseModel<>(ResponseStatusEnum.CREATED.getCode(), ResponseStatusEnum.CREATED.getMessage(), true, ResponseMessageEnum.CREATED_SUCCESSFULLY, newEvent);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.CREATED_ERROR,null);
    }


    public ResponseModel<Event> updateTitle(Event event){

        Event updatedEvent = eventRepository.findById(event.getId()).orElse(null);
        if(updatedEvent != null){
            updatedEvent.setTitle(event.getTitle());
            eventRepository.save(updatedEvent);
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.UPDATED_SUCCESSFULLY_DONE, updatedEvent);
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.UPDATED_ERROR, null);
    }

    public ResponseModel<Event> delete(Event event){
        Event deletedEvent = eventRepository.findById(event.getId()).orElse(null);
        if(deletedEvent != null){
            eventRepository.delete(deletedEvent);
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.DELETED_SUCCESSFULLY_DONE, deletedEvent);
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DELETED_ERROR, null);
    }


    public ResponseModel<List<Event>> listEventByCategory(Event event){

        List<Event> eventList = eventRepository.findEventsByCategoryId(event.getCategory().getId());
        if(eventList.isEmpty()){
            return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
        }
        return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE,eventList);
    }





}
