package com.myProject.eventPlatform.repository;

import com.myProject.eventPlatform.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {


}
