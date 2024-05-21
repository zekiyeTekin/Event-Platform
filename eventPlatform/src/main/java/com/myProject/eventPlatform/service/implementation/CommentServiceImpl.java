package com.myProject.eventPlatform.service.implementation;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.CommentDto;
import com.myProject.eventPlatform.entity.Comment;
import com.myProject.eventPlatform.entity.Community;
import com.myProject.eventPlatform.entity.Event;
import com.myProject.eventPlatform.entity.User;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseMessageEnum;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseStatusEnum;
import com.myProject.eventPlatform.mapper.CommentMapper;
import com.myProject.eventPlatform.repository.CommentRepository;
import com.myProject.eventPlatform.repository.CommunityRepository;
import com.myProject.eventPlatform.repository.EventRepository;
import com.myProject.eventPlatform.repository.UserRepository;
import com.myProject.eventPlatform.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;


    public ResponseModel<List<CommentDto>> getAll(){
        try{
            List<Comment> commentList = commentRepository.findAll();
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE, commentMapper.convertList(commentList));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
    }

    public ResponseModel<CommentDto> addCommentToCommunity(CommentDto commentDto){

        Community commentForCommunity = communityRepository.findById(commentDto.getCommunity().getId()).orElse(null);
        User commentForUser = userRepository.findById(commentDto.getUser().getId()).orElse(null);

        if(commentForUser != null && commentForCommunity != null ){
            Comment newComment = new Comment();

            newComment.setCommunity(commentForCommunity);
            newComment.setUser(commentForUser);
            newComment.setContent(commentDto.getContent());
            newComment.setType(commentDto.getType());
            newComment.setDate(LocalDate.now());
            newComment.setIsDeleted(false);

            Comment newCommunityComment = commentRepository.save(newComment);
            return new ResponseModel<>(ResponseStatusEnum.CREATED.getCode(), ResponseStatusEnum.CREATED.getMessage(), true, ResponseMessageEnum.CREATED_SUCCESSFULLY, commentMapper.toDto(newCommunityComment));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
    }


    public ResponseModel<CommentDto> addCommentToEvent(Comment comment){

        Event commentForEvent = eventRepository.findById(comment.getEvent().getId()).orElse(null);
        User commentForUser = userRepository.findById(comment.getUser().getId()).orElse(null);

        if(commentForUser != null && commentForEvent != null ){
            Comment newComment = new Comment();

            newComment.setEvent(commentForEvent);
            newComment.setUser(commentForUser);
            newComment.setContent(comment.getContent());
            newComment.setType(comment.getType());
            newComment.setDate(LocalDate.now());
            newComment.setIsDeleted(false);

            Comment newCommunityComment = commentRepository.save(newComment);
            return new ResponseModel<>(ResponseStatusEnum.CREATED.getCode(), ResponseStatusEnum.CREATED.getMessage(), true, ResponseMessageEnum.CREATED_SUCCESSFULLY, commentMapper.toDto(newCommunityComment));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
    }

     public ResponseModel<CommentDto> removeCommentToCommunityOrEvent(Integer commentId) {

         Comment comment = commentRepository.findById(commentId)
                 .orElseThrow(() -> new RuntimeException("Comment not found"));

         if (comment != null) {
             comment.setIsDeleted(true);
             Comment deletedComment = commentRepository.save(comment);
             return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.DELETED_SUCCESSFULLY_DONE, commentMapper.toDto(deletedComment));
         }
         return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
     }

    public ResponseModel<List<CommentDto>> listCommentByUserId(Integer userId){

        List<Comment> commentList = commentRepository.findByUserIdAndIsDeletedFalse(userId);
        if(!commentList.isEmpty()){
            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE, commentMapper.convertList(commentList));
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
    }


}
