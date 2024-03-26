package com.anotaai.anotaai.services;


import com.anotaai.anotaai.domain.category.Category;
import com.anotaai.anotaai.domain.category.CategoryDTO;
import com.anotaai.anotaai.domain.category.CategoryNotFoundException;
import com.anotaai.anotaai.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Category getOne(String id){
        Optional<Category> optionalCategory = repository.findById(id);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        }else{
            throw new RuntimeException("Categoria não localizada!");
        }
    }

    public Category update(String id, CategoryDTO categoryData){
        Category category = this.repository.findById(id).orElseThrow(CategoryNotFoundException::new);
        if (categoryData.title() != null && !categoryData.title().isEmpty()) {
            category.setTitle(categoryData.title());
        }
        if (categoryData.description() != null && !categoryData.description().isEmpty()) {
            category.setDescription(categoryData.description());
        }
        this.repository.save(category);

        return category;
    }

    public Optional<Category> getById(String id) {
        return repository.findById(id);
    }



}
