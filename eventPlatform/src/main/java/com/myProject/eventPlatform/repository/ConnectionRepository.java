package com.myProject.eventPlatform.repository;

import com.myProject.eventPlatform.entity.Connection;
import com.myProject.eventPlatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Integer> {


    List<Connection> findConnectionsByReceiver(User receiver);

    @Query("SELECT c FROM Connection c WHERE (c.sender.id = :receiverId OR c.receiver.id = :receiverId) AND c.status = true")
    List<Connection> findConnectionsByReceiverId(@Param("receiverId") Integer receiverId);

}

