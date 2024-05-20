package com.myProject.eventPlatform.mapper;

import com.myProject.eventPlatform.dto.CommunityUserDto;
import com.myProject.eventPlatform.dto.EventUserDto;
import com.myProject.eventPlatform.entity.CommunityUser;
import com.myProject.eventPlatform.entity.EventUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommunityUserMapper {



    private final UserMapper userMapper;
    private final CommunityMapper communityMapper;

    public CommunityUserMapper(UserMapper userMapper, CommunityMapper communityMapper) {
        this.userMapper = userMapper;
        this.communityMapper = communityMapper;
    }

    public CommunityUserDto toDto(CommunityUser communityUser){
        return CommunityUserDto.builder()
                .user(userMapper.toDto(communityUser.getUser()))
                .community(communityMapper.toDto(communityUser.getCommunity()))
                .id(communityUser.getId())
                .isActive(communityUser.getIsActive())
                .build();
    }

    public List<CommunityUserDto> convertList(List<CommunityUser> communityUserList){
        List<CommunityUserDto> communityUserDtoList = new ArrayList<>();
        for (CommunityUser communityUser : communityUserList){
            communityUserDtoList.add(toDto(communityUser));
        }
        return communityUserDtoList;
    }


}
