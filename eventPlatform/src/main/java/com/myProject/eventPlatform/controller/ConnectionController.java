package com.myProject.eventPlatform.controller;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.ConnectionDto;
import com.myProject.eventPlatform.entity.Connection;
import com.myProject.eventPlatform.entity.User;
import com.myProject.eventPlatform.service.ConnectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connection")
public class ConnectionController {

    private final ConnectionService connectionService;

    public ConnectionController(ConnectionService connectionService){
        this.connectionService = connectionService;
    }


    @GetMapping("/all")
    public ResponseModel<List<ConnectionDto>> getAll(){
        return connectionService.getAll();
    }

    @PostMapping("/send")
    public ResponseModel<ConnectionDto> sendConnectionRequest(@RequestBody Connection connection){
        return connectionService.sendConnectionRequest(connection);
    }

    //İstek var olduğunda (statusu false olanlar) statusu true yapar kabul eder. (bodye :{  "id": KabulEdilecekBağlantıIdSi })

    @PutMapping("/accepted")
    public ResponseModel<ConnectionDto> acceptedConnection(@RequestBody ConnectionDto connectionDto){
        return connectionService.acceptedConnection(connectionDto);
    }

    //status durumunu false'tan null'a çeker ve bu veriyi connection tablosundan siler istek reddedildiği için
    @PutMapping("/rejected")
    public ResponseModel<ConnectionDto> rejectConnection(@RequestBody Connection connection){
        return connectionService.rejectConnection(connection);
    }

    //Belirli bir kullanıcıya ait statusu false olanları getirir.
    @GetMapping("/by/receiver/statusFalse")
    public ResponseModel<List<ConnectionDto>> listConnectionWhenStatusFalse(@RequestBody Connection connection){
        return connectionService.listConnectionWhenStatusFalse(connection);
    }

    @GetMapping("/by/user")
    public ResponseModel<List<ConnectionDto>> getUserConnection(@RequestParam Integer receiverId){
        return connectionService.getUserConnection(receiverId);
    }





}
