package com.myProject.eventPlatform.controller;

import com.myProject.eventPlatform.common.ResponseModel;
import com.myProject.eventPlatform.dto.CategoryDto;
import com.myProject.eventPlatform.entity.Category;
import com.myProject.eventPlatform.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/getAll")
    public ResponseModel<List<CategoryDto>> getAll(){
        return categoryService.getALl();
    }

    @PostMapping("/create")
    public ResponseModel<Category> create(@RequestBody Category category){
        return categoryService.create(category);
    }


}
