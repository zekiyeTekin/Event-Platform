package com.myProject.eventPlatform.controller;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.entity.Event;
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
    public ResponseModel<List<Event>> getAll(){
        return eventService.getAll();
    }

    @PostMapping("/create")
    public ResponseModel<Event> create(@RequestBody Event event){
        return eventService.create(event);
    }

    @PutMapping("/update")
    public ResponseModel<Event> updateTitle(@RequestBody Event event){
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




}
