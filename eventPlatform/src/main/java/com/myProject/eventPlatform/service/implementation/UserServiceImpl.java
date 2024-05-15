package com.myProject.eventPlatform.service.implementation;

import com.myProject.eventPlatform.dto.UserDto;
import com.myProject.eventPlatform.entity.User;
import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseMessageEnum;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseStatusEnum;
import com.myProject.eventPlatform.mapper.UserMapper;
import com.myProject.eventPlatform.repository.UserRepository;
import com.myProject.eventPlatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;



    public ResponseModel<List<UserDto>> getAllUsers(){
        try{
            List<User> userList = userRepository.findAll();
            //ResponseModel<List<UserDto>> responseModel = new ResponseModel<List<UserDto>>();
            //responseModel.setCode(ResponseStatusEnum.OK.getCode());
            //responseModel.setCodeMessage(ResponseStatusEnum.OK.getMessage());
            //responseModel.setMessage(ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE);
            //responseModel.setSuccess(true);
            //responseModel.setData(userMapper.convertList(userList));
            //return responseModel;
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE, userMapper.convertList(userList));
        }catch (Exception e){
            System.out.println(e);;
        }
        return new ResponseModel<>();
    }


    public ResponseModel<List<UserDto>> getUsersByActiveState(){
       // ResponseModel<List<UserDto>> responseModel = new ResponseModel<List<UserDto>>();
        try{
            List<User> users = userRepository.getUsersByIsActiveTrue();
            //responseModel.setData(userMapper.convertList(users));
            //responseModel.setSuccess(true);
            //responseModel.setCode(ResponseStatusEnum.OK.getCode());
            //responseModel.setCodeMessage(ResponseStatusEnum.OK.getMessage());
            //responseModel.setMessage(ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE);
            //return responseModel;
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE, userMapper.convertList(users));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false,ResponseMessageEnum.DATA_NOT_FOUND, null);
    }


    public ResponseModel<UserDto> save(UserDto userDto){

        User newUser = userRepository.save(userMapper.toEntity(userDto));
        //ResponseModel<UserDto> responseModel = new ResponseModel<UserDto>();
        //responseModel.setData(userMapper.toDto(newUser));
        //responseModel.setSuccess(true);
        //responseModel.setCode(ResponseStatusEnum.CREATED.getCode());
        //responseModel.setCodeMessage(ResponseStatusEnum.CREATED.getMessage());
        //responseModel.setMessage(ResponseMessageEnum.CREATED_SUCCESSFULLY);
        //return responseModel;
        return new ResponseModel<>(ResponseStatusEnum.CREATED.getCode(), ResponseStatusEnum.CREATED.getMessage(), true, ResponseMessageEnum.CREATED_SUCCESSFULLY, userMapper.toDto(newUser));
    }


    public ResponseModel<UserDto> updateMail(UserDto userDto){
       // ResponseModel<UserDto> responseModel = new ResponseModel<UserDto>();
        Integer userId = userDto.getId();
        User updateUser = userRepository.findById(userId).orElse(null);

        if(updateUser == null){
           //responseModel.setSuccess(false);
           //responseModel.setMessage(ResponseMessageEnum.DATA_NOT_FOUND);
           //responseModel.setCode(ResponseStatusEnum.NOT_FOUND.getCode());
           //responseModel.setCodeMessage(ResponseStatusEnum.NOT_FOUND.getMessage());
           //return responseModel;
           return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode() ,ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
        }
        else{
            updateUser.setMail(userDto.getMail());
            userRepository.save(updateUser);
            //responseModel.setData(userMapper.toDto(updateUser));
            //responseModel.setSuccess(true);
            //responseModel.setCode(ResponseStatusEnum.OK.getCode());
            //responseModel.setCodeMessage(ResponseStatusEnum.OK.getMessage());
            //responseModel.setMessage(ResponseMessageEnum.UPDATED_SUCCESSFULLY_DONE);
            //return responseModel;
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.UPDATED_SUCCESSFULLY_DONE, userMapper.toDto(updateUser) );
        }
    }


    public ResponseModel<UserDto> delete(UserDto userDto){

        //ResponseModel<UserDto> responseModel = new ResponseModel<UserDto>();
        User deletedUser = userRepository.findById(userDto.getId()).orElse(null);

        if(deletedUser != null){
            userRepository.delete(deletedUser);
            //responseModel.setData(null); // tekrar obje koyamam çünkü obje silinmiş oluyor.
            //responseModel.setMessage(ResponseMessageEnum.DELETED_SUCCESSFULLY_DONE);
            //responseModel.setSuccess(true);
            //responseModel.setCode(ResponseStatusEnum.OK.getCode());
            //responseModel.setCodeMessage(ResponseStatusEnum.OK.getMessage());
            //return responseModel;
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.DELETED_SUCCESSFULLY_DONE, null);
        }else{
            return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false,ResponseMessageEnum.DATA_NOT_FOUND, null);
        }
    }



}
