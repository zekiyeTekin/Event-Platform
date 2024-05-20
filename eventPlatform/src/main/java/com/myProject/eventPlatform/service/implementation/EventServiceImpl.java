package com.myProject.eventPlatform.service.implementation;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.EventDto;
import com.myProject.eventPlatform.entity.Event;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseMessageEnum;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseStatusEnum;
import com.myProject.eventPlatform.filter.EventFilter;
import com.myProject.eventPlatform.mapper.EventMapper;
import com.myProject.eventPlatform.repository.EventRepository;
import com.myProject.eventPlatform.service.EventService;
import com.myProject.eventPlatform.specification.EventSpecification;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    @PersistenceContext
    private EntityManager entityManager;


    public ResponseModel<List<EventDto>> getAll(){
        try {
            List<Event> eventList = eventRepository.findAll();
            if(!eventList.isEmpty()){
                return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE, eventMapper.convertList(eventList));
            }
        }catch (Exception e){
            e.printStackTrace();
            }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND,null);
    }

    public ResponseModel<EventDto> create(Event event){
        try {

            eventRepository.save(event);

            entityManager.detach(event);

            Event newEvent = eventRepository.findById(event.getId()).get();
            return new ResponseModel<>(ResponseStatusEnum.CREATED.getCode(), ResponseStatusEnum.CREATED.getMessage(), true, ResponseMessageEnum.CREATED_SUCCESSFULLY, eventMapper.toDto(newEvent));
        }catch (Exception e){
           e.printStackTrace();
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.CREATED_ERROR, null);
    }


    public ResponseModel<EventDto> updateTitle(Event event){

        Event updatedEvent = eventRepository.findById(event.getId()).orElse(null);
        if(updatedEvent != null){
            updatedEvent.setTitle(event.getTitle());
            eventRepository.save(updatedEvent);
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.UPDATED_SUCCESSFULLY_DONE, eventMapper.toDto(updatedEvent));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.UPDATED_ERROR, null);
    }

    public ResponseModel<EventDto> delete(Event event){
        Event deletedEvent = eventRepository.findById(event.getId()).orElse(null);
        if(deletedEvent != null){
            eventRepository.delete(deletedEvent);
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.DELETED_SUCCESSFULLY_DONE, eventMapper.toDto(deletedEvent));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DELETED_ERROR, null);
    }


    public ResponseModel<List<EventDto>> listEventByCategory(Event event){

        List<Event> eventList = eventRepository.findEventsByCategoryId(event.getCategory().getId());
        if(eventList.isEmpty()){
            return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
        }
        return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE, eventMapper.convertList(eventList));
    }

    public ResponseModel<List<EventDto>> searchByDateWithFilter(EventFilter eventFilter){
        List<Event> eventFilterList = eventRepository.findAll(EventSpecification.searchByDate(eventFilter));
        if (!eventFilterList.isEmpty()){
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.SEARCHED_SUCCESSFULLY, eventMapper.convertList(eventFilterList));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.SEARCHED_ERROR, null);
    }

    public ResponseModel<List<EventDto>> searchByCategoryTypeWithFilter(EventFilter eventFilter) {
        List<Event> eventFilterList =eventRepository.findAll(EventSpecification.searchByCategoryName(eventFilter));
        if (!eventFilterList.isEmpty()){
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.SEARCHED_SUCCESSFULLY, eventMapper.convertList(eventFilterList));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.SEARCHED_ERROR, null);
    }
    public ResponseModel<List<EventDto>> searchByAddressWithFilter(EventFilter eventFilter){
        List<Event> eventFilterList = eventRepository.findAll(EventSpecification.searchByAddress(eventFilter));
        if (!eventFilterList.isEmpty()){
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.SEARCHED_SUCCESSFULLY, eventMapper.convertList(eventFilterList));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.SEARCHED_ERROR, null);
    }

    public ResponseModel<List<EventDto>> searchByCommunityWithFilter(EventFilter eventFilter){
        List<Event> eventFilterList = eventRepository.findAll(EventSpecification.searchByCommunity(eventFilter));
        if (!eventFilterList.isEmpty()){
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.SEARCHED_SUCCESSFULLY, eventMapper.convertList(eventFilterList));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.SEARCHED_ERROR, null);
    }


}
