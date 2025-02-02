package com.ecommerce.project.controller;


import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController  {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/public/categories")
    private List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Category created successfully";
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
       String status = categoryService.deleteCategory(categoryId);
         return status;
    }
}
