package com.myProject.eventPlatform.repository;

import com.myProject.eventPlatform.dto.UserDto;
import com.myProject.eventPlatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> getUsersByIsActiveTrue();




}
