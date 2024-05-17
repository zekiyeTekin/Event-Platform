package com.myProject.eventPlatform.controller;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.CommunityDto;
import com.myProject.eventPlatform.entity.Community;
import com.myProject.eventPlatform.enumuration.category.TypeEnum;
import com.myProject.eventPlatform.repository.CommunityRepository;
import com.myProject.eventPlatform.service.CommunityService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community")
public class CommunityController {

    private final CommunityService communityService;
    public CommunityController(CommunityService communityService){
        this.communityService = communityService;
    }


    @GetMapping("/getAll")
    public ResponseModel<List<CommunityDto>> getAll(){
        return communityService.getAll();
    }

    @PostMapping("/add")
    public ResponseModel<CommunityDto> add(@RequestBody CommunityDto communityDto){
        return communityService.add(communityDto);
    }

    @DeleteMapping("/delete")
    public ResponseModel<CommunityDto> delete(@RequestBody CommunityDto communityDto){
        return communityService.delete(communityDto);
    }

    @PutMapping("/updateTitle")
    public ResponseModel<CommunityDto> updateTitle(@RequestBody CommunityDto communityDto){
        return communityService.updateTitle(communityDto);
    }

    //Category id'e göre communities getir
    @GetMapping("/by/category")
    public ResponseModel<List<CommunityDto>> getCommunityByCategoryId(@RequestParam Integer id){
        return communityService.getCommunityByCategoryId(id);
    }

    //Category'nin type'ına göre communities getir
    @GetMapping("/by/category/type")
    public ResponseModel<List<CommunityDto>> communitiesByCategoryType(@RequestParam TypeEnum type){
        return  communityService.communitiesByCategoryType(type);
    }

    /*    @PostMapping("/add/byId")
    public ResponseModel<CommunityDto> listById(@RequestBody CommunityDto communityDto){
        return communityService.listById(communityDto);
    }*/







}
