package com.myProject.eventPlatform.service.implementation;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.CategoryDto;
import com.myProject.eventPlatform.entity.Category;
import com.myProject.eventPlatform.entity.Community;
import com.myProject.eventPlatform.enumuration.category.TypeEnum;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseMessageEnum;
import com.myProject.eventPlatform.enumuration.responseModel.ResponseStatusEnum;
import com.myProject.eventPlatform.mapper.CategoryMapper;
import com.myProject.eventPlatform.repository.CategoryRepository;
import com.myProject.eventPlatform.service.CategoryService;
import org.hibernate.dialect.function.array.ArrayToStringFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public ResponseModel<List<CategoryDto>> getALl(){
        try{
            List<Category> categoryList = categoryRepository.findAll();

            return new ResponseModel<>(ResponseStatusEnum.OK.getCode(), ResponseStatusEnum.OK.getMessage(), true, ResponseMessageEnum.LISTING_SUCCESSFULLY_DONE,categoryMapper.convertList(categoryList));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);

    }


    public ResponseModel<Category> create(Category category){

        try{
            Category newCategory = categoryRepository.save(category);
            return new ResponseModel<>(ResponseStatusEnum.CREATED.getCode(), ResponseStatusEnum.CREATED.getMessage(), true, ResponseMessageEnum.CREATED_SUCCESSFULLY, newCategory);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseModel<>(ResponseStatusEnum.NOT_FOUND.getCode(), ResponseStatusEnum.NOT_FOUND.getMessage(), false, ResponseMessageEnum.DATA_NOT_FOUND, null);
    }



}
