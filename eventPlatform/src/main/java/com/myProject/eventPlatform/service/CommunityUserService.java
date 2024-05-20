package com.myProject.eventPlatform.service;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.CommunityUserDto;
import com.myProject.eventPlatform.entity.CommunityUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CommunityUserService {


    ResponseModel<List<CommunityUserDto>> getAll();

    ResponseModel<CommunityUserDto> getById(Integer id);

    ResponseModel<CommunityUserDto> add(CommunityUser communityUser);

    ResponseModel<List<CommunityUserDto>> getCommunityUsersByEvent(Integer id);





}
