package com.learn.app.demorestapi.respository;

// Create a repository interface ProductRepository that extends MongoRepository
// Add method to get Products based on Category

import com.learn.app.demorestapi.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByCategory(String category);
// Method to get products by name
    List<Product> findByName(String name);
// Method to get products by price RANGE
    List<Product> findByPriceBetween(double min, double max);
}