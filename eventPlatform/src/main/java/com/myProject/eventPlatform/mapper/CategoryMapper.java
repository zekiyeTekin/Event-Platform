package com.myProject.eventPlatform.mapper;

import com.myProject.eventPlatform.dto.CategoryDto;
import com.myProject.eventPlatform.entity.Category;
import com.myProject.eventPlatform.entity.Community;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {

    public CategoryDto toDto(Category category){

        return new CategoryDto.Builder()
                .id(category.getId())
                .type(category.getType())
                .isActive(category.getIsActive())
                .build();
    }

    public List<CategoryDto>  convertList(List<Category> categoryList){
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for(Category category : categoryList){
            categoryDtoList.add(toDto(category));
        }
        return categoryDtoList;
    }

    public Category toEntity(CategoryDto categoryDto){
        Category category = new Category();

        category.setId(categoryDto.getId());
        category.setType(category.getType());
        category.setIsActive(categoryDto.getIsActive());
        return category;
    }




}
