package com.myProject.eventPlatform.service.implementation;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.CommunityDto;
import com.myProject.eventPlatform.entity.Community;
import com.myProject.eventPlatform.enumuration.category.TypeEnum;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseMessageEnum;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseStatusEnum;
import com.myProject.eventPlatform.mapper.CommunityMapper;
import com.myProject.eventPlatform.repository.CommunityRepository;
import com.myProject.eventPlatform.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityMapper communityMapper;

    private final CommunityRepository communityRepository;

    public CommunityServiceImpl(CommunityRepository communityRepository){
        this.communityRepository = communityRepository;
    }

    public ResponseModel<List<CommunityDto>> getAll(){
        try{
            List<Community> communityList = communityRepository.findAll();
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE, communityMapper.convertList(communityList));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);

    }

    public ResponseModel<CommunityDto> add(CommunityDto communityDto){
        try{
            Community newCommunity = communityRepository.save(communityMapper.toEntity(communityDto));
            return new ResponseModel<>(ResponseStatusEnum.CREATED.getCode(), ResponseStatusEnum.CREATED.getMessage(), true, ResponseMessageEnum.CREATED_SUCCESSFULLY,communityMapper.toDto(newCommunity));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
    }


    public ResponseModel<CommunityDto> delete(CommunityDto communityDto){

        Community deletedCommunity = communityRepository.findById(communityDto.getId()).orElse(null);
        if(deletedCommunity != null){
            communityRepository.delete(deletedCommunity);
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.DELETED_SUCCESSFULLY_DONE, null);
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false,ResponseMessageEnum.DATA_NOT_FOUND, null);
    }

    public ResponseModel<CommunityDto> updateTitle(CommunityDto communityDto){

        Community updatedCommunity = communityRepository.findById(communityDto.getId()).orElse(null);
        if( updatedCommunity != null){
            updatedCommunity.setTitle(communityDto.getTitle());
            communityRepository.save(updatedCommunity);
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.UPDATED_SUCCESSFULLY_DONE, communityMapper.toDto(updatedCommunity));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
    }

    //category id'e göre topluluk ne
    public ResponseModel<List<CommunityDto>> getCommunityByCategoryId(Integer id){

        List<Community> communityList = communityRepository.findCommunitiesByCategory_Id(id);
        if(communityList != null){
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE, communityMapper.convertList(communityList));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false,ResponseMessageEnum.DATA_NOT_FOUND, new ArrayList<>());
    }

    public ResponseModel<List<CommunityDto>> communitiesByCategoryType(TypeEnum type){

        List<Community> communityList = communityRepository.findCommunitiesByCategory_Type(type);
        if(communityList.isEmpty()){
            return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false,ResponseMessageEnum.DATA_NOT_FOUND, new ArrayList<>());

        }
        return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE, communityMapper.convertList(communityList));
    }







}




