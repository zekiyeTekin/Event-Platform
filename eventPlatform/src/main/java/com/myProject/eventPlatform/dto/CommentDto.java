package com.myProject.eventPlatform.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myProject.eventPlatform.dto.forCommentDto.CommunityDtoForComment;
import com.myProject.eventPlatform.dto.forCommentDto.EventDtoForComment;
import com.myProject.eventPlatform.dto.forCommentDto.UserDtoForComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder

public class CommentDto {


    private Integer id;

    private String type;

    private LocalDate date;

    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CommunityDtoForComment community;

    private UserDtoForComment user;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EventDtoForComment event;



}
