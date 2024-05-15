package com.myProject.eventPlatform.repository;

import com.myProject.eventPlatform.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findEventsByCategoryId(Integer categoryId);
}
