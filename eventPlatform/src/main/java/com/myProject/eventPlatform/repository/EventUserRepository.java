package com.myProject.eventPlatform.repository;

import com.myProject.eventPlatform.entity.EventUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventUserRepository extends JpaRepository<EventUser,Integer> {

    List<EventUser> findEventUsersByEvent_Id(Integer id);
}
