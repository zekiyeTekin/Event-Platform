package com.myProject.eventPlatform.service;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.CommunityDto;
import com.myProject.eventPlatform.entity.Community;
import com.myProject.eventPlatform.enumuration.category.TypeEnum;

import java.util.List;

public interface CommunityService {

    ResponseModel<List<CommunityDto>> getAll();

    ResponseModel<CommunityDto> add(CommunityDto communityDto);

    ResponseModel<CommunityDto> delete(CommunityDto communityDto);

    ResponseModel<CommunityDto> updateTitle(CommunityDto communityDto);

    ResponseModel<List<CommunityDto>> getCommunityByCategoryId(Integer id);

    ResponseModel<List<CommunityDto>> communitiesByCategoryType(TypeEnum type);

}
