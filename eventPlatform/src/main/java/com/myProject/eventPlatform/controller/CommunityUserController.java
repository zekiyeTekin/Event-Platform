package com.myProject.eventPlatform.controller;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.CommunityUserDto;
import com.myProject.eventPlatform.entity.CommunityUser;
import com.myProject.eventPlatform.entity.EventUser;
import com.myProject.eventPlatform.service.CommunityService;
import com.myProject.eventPlatform.service.CommunityUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/communityUser")
public class CommunityUserController {

    private final CommunityUserService communityUserService;

    public CommunityUserController(CommunityUserService communityUserService){
        this.communityUserService =communityUserService;
    }


    @GetMapping("/all")
    public ResponseModel<List<CommunityUserDto>> getAll(){
        return communityUserService.getAll();
    }

    @GetMapping("/byId")
    public ResponseModel<CommunityUserDto> getById(@RequestParam Integer id){
        return communityUserService.getById(id);
    }

    @PostMapping("/add")
    public ResponseModel<CommunityUserDto> add(@RequestBody CommunityUser communityUser){
        return communityUserService.add(communityUser);
    }

    //belirli bir topluluğa kayıtlı kullanıcılar
    @GetMapping("/list/by/community")
    public ResponseModel<List<CommunityUserDto>> getCommunityUsersByEvent(@RequestParam Integer id){
        return communityUserService.getCommunityUsersByEvent(id);
    }





}
