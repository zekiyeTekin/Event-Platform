package com.myProject.eventPlatform.service.implementation;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.CommunityUserDto;
import com.myProject.eventPlatform.entity.CommunityUser;
import com.myProject.eventPlatform.entity.Event;
import com.myProject.eventPlatform.entity.EventUser;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseMessageEnum;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseStatusEnum;
import com.myProject.eventPlatform.mapper.CommunityUserMapper;
import com.myProject.eventPlatform.repository.CommunityUserRepository;
import com.myProject.eventPlatform.repository.EventUserRepository;
import com.myProject.eventPlatform.service.CommunityService;
import com.myProject.eventPlatform.service.CommunityUserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityUserServiceImpl implements CommunityUserService {

    @PersistenceContext
    private EntityManager entityManager;

    private final CommunityUserRepository communityUserRepository;
    private final CommunityUserMapper communityUserMapper;
    public CommunityUserServiceImpl(CommunityUserRepository communityUserRepository, CommunityUserMapper communityUserMapper) {
        this.communityUserRepository = communityUserRepository;
        this.communityUserMapper = communityUserMapper;
    }

    public ResponseModel<List<CommunityUserDto>> getAll(){
        List<CommunityUser> communityUser = communityUserRepository.findAll();
        if (!communityUser.isEmpty()){
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE, communityUserMapper.convertList(communityUser));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
    }

    public ResponseModel<CommunityUserDto> getById(Integer id){
        CommunityUser communityUser = communityUserRepository.findById(id).orElse(null);
        if( communityUser != null ){
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.SUCCESSFULLY_DONE, communityUserMapper.toDto(communityUser));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
    }


    public ResponseModel<CommunityUserDto> add(CommunityUser communityUser){
        try{

            communityUserRepository.save(communityUser);

            entityManager.detach(communityUser);

            CommunityUser newCommunityUser = communityUserRepository.findById(communityUser.getId()).orElse(null);

            if(newCommunityUser != null){
                return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE, communityUserMapper.toDto(newCommunityUser));
            }

            // CommunityUser newCommunityUser = communityUserRepository.save(communityUser);
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.CREATED_SUCCESSFULLY, communityUserMapper.toDto(newCommunityUser));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.CREATED_ERROR, null);
    }


    public ResponseModel<List<CommunityUserDto>> getCommunityUsersByEvent(Integer id){
        List<CommunityUser> communityUserList = communityUserRepository.findCommunityUsersByCommunity_Id(id);
        if( communityUserList != null ){
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.CREATED_SUCCESSFULLY, communityUserMapper.convertList(communityUserList));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.CREATED_ERROR, null);
    }


}
