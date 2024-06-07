package com.myProject.eventPlatform.controller;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.UserDto;
import com.myProject.eventPlatform.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", maxAge=3600)
public class UserController {



    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }



    //http://localhost:8086/user/allUsers
    @GetMapping("/allUsers")
    public ResponseModel<List<UserDto>> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/active")
    public ResponseModel<List<UserDto>> getUsersByActiveState(){
        return userService.getUsersByActiveState();
    }

    //http://localhost:8086/user/create
    @PostMapping("/create")
    public ResponseModel<UserDto> create(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    //http://localhost:8086/user/update
    @PutMapping("/update")
    public ResponseModel<UserDto> updateMail(@RequestBody UserDto userDto){
        return userService.updateMail(userDto);
    }

    @DeleteMapping("/delete")
    public ResponseModel<UserDto> delete(@RequestBody UserDto userDto){
        return userService.delete(userDto);
    }












}
