package com.myProject.eventPlatform.service;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.CommentDto;
import com.myProject.eventPlatform.entity.Comment;

import java.util.List;

public interface CommentService {

    ResponseModel<List<CommentDto>> getAll();
    ResponseModel<CommentDto> addCommentToCommunity(CommentDto commentDto);

    ResponseModel<CommentDto> addCommentToEvent(Comment comment);
    ResponseModel<CommentDto> removeCommentToCommunityOrEvent(Integer commentId);

    ResponseModel<List<CommentDto>> listCommentByUserId(Integer userId);


}
