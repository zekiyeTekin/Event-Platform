package com.myProject.eventPlatform.repository;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.CommunityDto;
import com.myProject.eventPlatform.entity.Category;
import com.myProject.eventPlatform.entity.Community;
import com.myProject.eventPlatform.enumuration.category.TypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Integer> {

//bu iki sorgu da çalışıyor
   // List<Community> findByCategory_Id(Integer id);
    List<Community> findCommunitiesByCategory_Id(Integer id);

    List<Community> findCommunitiesByCategory_Type(TypeEnum type);
}
