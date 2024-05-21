package com.myProject.eventPlatform.repository;

import com.myProject.eventPlatform.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {


   List<Comment> findByUserIdAndIsDeletedFalse(Integer userId);



}
