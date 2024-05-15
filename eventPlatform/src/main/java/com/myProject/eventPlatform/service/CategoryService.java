package com.myProject.eventPlatform.service;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.CategoryDto;
import com.myProject.eventPlatform.entity.Category;

import java.util.List;

public interface CategoryService {

     ResponseModel<List<CategoryDto>> getALl();

     ResponseModel<Category> create(Category category);

}
