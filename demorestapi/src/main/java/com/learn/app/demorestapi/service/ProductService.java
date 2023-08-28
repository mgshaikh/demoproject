package com.learn.app.demorestapi.service;

import com.learn.app.demorestapi.model.Product;

import java.util.List;

public interface ProductService {
// Methods for doing CRUD operations on Product

    List<Product> getAllProducts();

    Product getProductById(String id);

    Product addProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(String id);

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByPriceRange(double min, double max);
    
}
