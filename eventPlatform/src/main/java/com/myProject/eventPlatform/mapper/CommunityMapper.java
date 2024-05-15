package com.myProject.eventPlatform.mapper;

import com.myProject.eventPlatform.dto.CommunityDto;
import com.myProject.eventPlatform.dto.UserDto;
import com.myProject.eventPlatform.entity.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommunityMapper {


    @Autowired
    private CategoryMapper categoryMapper;

    public CommunityDto toDto(Community community) {
        return new CommunityDto.Builder()
                .id(community.getId())
                .title(community.getTitle())
                .details(community.getDetails())
                .address(community.getAddress())
                .category(categoryMapper.toDto(community.getCategory()))
                .isActive(community.getIsActive())
                .build();


}

    public List<CommunityDto> convertList(List<Community> communityList){
        List<CommunityDto> communityDtoList = new ArrayList<>();

        for(Community community : communityList){
            communityDtoList.add(toDto(community));
        }
        return communityDtoList;
    }

    public Community toEntity(CommunityDto communityDto){
        Community community = new Community();

        community.setId(communityDto.getId());
        community.setCategory(categoryMapper.toEntity(communityDto.getCategory()));
        community.setIsActive(communityDto.getIsActive());
        community.setAddress(communityDto.getAddress());
        community.setDetails(communityDto.getDetails());
        community.setTitle(communityDto.getTitle());
        return community;

    }


}
