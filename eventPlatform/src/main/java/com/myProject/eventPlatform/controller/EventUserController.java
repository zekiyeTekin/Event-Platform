package com.myProject.eventPlatform.controller;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.EventUserDto;
import com.myProject.eventPlatform.entity.EventUser;
import com.myProject.eventPlatform.service.EventUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventUser")
@CrossOrigin(origins = "*", maxAge=3600)
public class EventUserController {

    private final EventUserService eventUserService;
    public EventUserController(EventUserService eventUserService) {
        this.eventUserService = eventUserService;
    }

    @GetMapping("/all")
    public ResponseModel<List<EventUserDto>> getAll(){
        return eventUserService.getAll();
    }

    @GetMapping("/byId")
    public ResponseModel<EventUserDto> getById(@RequestParam Integer id){
        return eventUserService.getById(id);
    }

    @PostMapping("/add")
    public ResponseModel<EventUserDto> add(@RequestBody EventUser eventUser){
        return eventUserService.add(eventUser);
    }

    //bir etkinliğe katılan katılımcılar listesi
    @GetMapping("/list/by/event")
    public ResponseModel<List<EventUserDto>> getEventUsersByEvent(@RequestParam Integer id){
        return eventUserService.getEventUsersByEvent(id);
    }









}
