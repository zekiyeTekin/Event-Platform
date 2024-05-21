package com.myProject.eventPlatform.mapper;

import com.myProject.eventPlatform.dto.CommentDto;
import com.myProject.eventPlatform.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CommentMapper {

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommunityMapper communityMapper;


    public CommentDto toDto(Comment comment){

        CommentDto.CommentDtoBuilder builder = CommentDto.builder()
                .id(comment.getId())
                .date(comment.getDate())
                .content(comment.getContent())
                .type(comment.getType())
                .user(userMapper.toDtoForComment(comment.getUser()));

        if (comment.getEvent() != null ) {
            builder.event(eventMapper.toDtoForComment(comment.getEvent()));
            builder.community(null);
        } else {
            builder.event(null);
            if (comment.getCommunity() != null ) {
                builder.community(communityMapper.toDtoForComment(comment.getCommunity()));
            }
        }
        return builder.build();
    }

    public List<CommentDto> convertList(List<Comment> commentList){
        List<CommentDto> commentDtoList = new ArrayList<>();

        for(Comment comment : commentList){
            commentDtoList.add(toDto(comment));
        }
        return commentDtoList;
    }



}
