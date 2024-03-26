package com.anotaai.anotaai.services;


import com.anotaai.anotaai.domain.category.Category;
import com.anotaai.anotaai.domain.category.CategoryDTO;
import com.anotaai.anotaai.domain.category.CategoryNotFoundException;
import com.anotaai.anotaai.domain.product.Product;
import com.anotaai.anotaai.domain.product.ProductDTO;
import com.anotaai.anotaai.repository.CategoryRepository;
import com.anotaai.anotaai.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryService categoryService;

    public Product insert(ProductDTO productData){
        Category category = categoryService.getById(productData.categoryId()).orElseThrow(CategoryNotFoundException::new);
        Product product = new Product(productData);
        product.setCategory(category);
        repository.save(product);
        return product;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product getOne(String id){
        Optional<Product> optionalProduct = repository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }else{
            throw new RuntimeException("Produto não localizado!");
        }
    }

//    public Product update(String id, CategoryDTO categoryData){
//        Product product = repository.findById(id).orElseThrow(CategoryNotFoundException::new);
//        category.update(categoryData);
//        repository.save(category);
//        return category;
//    }


}
