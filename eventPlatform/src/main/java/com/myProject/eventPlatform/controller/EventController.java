package com.myProject.eventPlatform.controller;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.EventDto;
import com.myProject.eventPlatform.entity.Event;
import com.myProject.eventPlatform.filter.EventFilter;
import com.myProject.eventPlatform.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/getAll")
    public ResponseModel<List<EventDto>> getAll(){
        return eventService.getAll();
    }

    @PostMapping("/create")
    public ResponseModel<EventDto> create(@RequestBody Event event){
        return eventService.create(event);
    }

    @PutMapping("/update")
    public ResponseModel<EventDto> updateTitle(@RequestBody Event event){
        return eventService.updateTitle(event);
    }

    @DeleteMapping("/delete")
    public ResponseModel<Event> delete(@RequestBody Event event){
        return eventService.delete(event);
    }

    @GetMapping("/list/by/category")
    public ResponseModel<List<Event>> listEventByCategory(@RequestBody Event event){
        return eventService.listEventByCategory(event);
    }

    @PostMapping("/filter/by/date")
    public ResponseModel<List<Event>> searchByDateWithFilter(@RequestBody EventFilter eventFilter){
        return eventService.searchByDateWithFilter(eventFilter);
    }

    @PostMapping("/filter/by/category")
    public ResponseModel<List<Event>> searchByCategoryTypeWithFilter(@RequestBody EventFilter eventFilter){
        return eventService.searchByCategoryTypeWithFilter(eventFilter);
    }

    @PostMapping("/filter/by/address")
    public ResponseModel<List<Event>> searchByAddressWithFilter(@RequestBody EventFilter eventFilter){
        return eventService.searchByAddressWithFilter(eventFilter);
    }



}
