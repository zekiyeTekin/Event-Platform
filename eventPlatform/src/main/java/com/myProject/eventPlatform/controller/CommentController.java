package com.myProject.eventPlatform.controller;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.CommentDto;
import com.myProject.eventPlatform.entity.Comment;
import com.myProject.eventPlatform.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "*", maxAge=3600)
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/all")
    public  ResponseModel<List<CommentDto>> getAll(){
        return commentService.getAll();
    }
    @PostMapping("/add/toCommunity")
    public ResponseModel<CommentDto> addCommentToCommunity(@RequestBody CommentDto commentDto){
        return commentService.addCommentToCommunity(commentDto);
    }
    @PostMapping("/add/toEvent")
    public ResponseModel<CommentDto> addCommentToEvent(@RequestBody Comment comment){
        return commentService.addCommentToEvent(comment);
    }

    @GetMapping("/remove")
    public ResponseModel<CommentDto> removeCommentToCommunityOrEvent(@RequestParam Integer commentId){
        return commentService.removeCommentToCommunityOrEvent(commentId);
    }

    @GetMapping("/listCommentByUser")
    public ResponseModel<List<CommentDto>> listCommentByUserId(@RequestParam Integer userId){
        return commentService.listCommentByUserId(userId);
    }





}
