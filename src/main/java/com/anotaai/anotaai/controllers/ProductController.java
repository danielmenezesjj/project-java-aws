package com.anotaai.anotaai.controllers;


import com.anotaai.anotaai.domain.category.Category;
import com.anotaai.anotaai.domain.category.CategoryDTO;
import com.anotaai.anotaai.domain.product.Product;
import com.anotaai.anotaai.domain.product.ProductDTO;
import com.anotaai.anotaai.services.CategoryService;
import com.anotaai.anotaai.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {


    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productData){
        Product product = service.insert(productData);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> gettAll(){
        List<Product> products = service.getAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@PathVariable String id){
        var product = service.getOne(id);
        return ResponseEntity.ok(product);
    }

//    @PutMapping("/{id}")
//    @Transactional
//    public ResponseEntity<Category> update(@PathVariable String id, CategoryDTO categorydata){
//        var category = service.update(id, categorydata);
//        return ResponseEntity.ok().body(category);
//    }


}
