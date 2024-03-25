package com.anotaai.anotaai.services;


import com.anotaai.anotaai.domain.category.Category;
import com.anotaai.anotaai.domain.category.CategoryDTO;
import com.anotaai.anotaai.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category insert(CategoryDTO categoryData){
        Category category = new Category(categoryData);
         repository.save(category);
         return category;
    }

    public List<Category> getAll() {
        return repository.findAll();
    }
}
