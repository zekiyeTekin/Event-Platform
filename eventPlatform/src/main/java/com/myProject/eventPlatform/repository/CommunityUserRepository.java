package com.myProject.eventPlatform.repository;

import com.myProject.eventPlatform.entity.CommunityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityUserRepository extends JpaRepository<CommunityUser,Integer> {
}
