package com.anotaai.anotaai.controllers;


import com.anotaai.anotaai.domain.category.Category;
import com.anotaai.anotaai.domain.category.CategoryDTO;
import com.anotaai.anotaai.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {


    @Autowired
    private CategoryService service;

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryData){
        Category category = service.insert(categoryData);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> gettAll(){
        List<Category> categories = service.getAll();
        return ResponseEntity.ok(categories);
    }


}
