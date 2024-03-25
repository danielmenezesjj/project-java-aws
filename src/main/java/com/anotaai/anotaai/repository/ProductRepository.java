package com.anotaai.anotaai.repository;

import com.anotaai.anotaai.domain.category.Category;
import com.anotaai.anotaai.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
