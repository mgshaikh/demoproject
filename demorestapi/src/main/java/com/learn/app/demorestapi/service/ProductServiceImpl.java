package com.learn.app.demorestapi.service;
// Create a service class ProductServiceImpl that implements ProductService
// Use ProductRepository to do CRUD operations on Product
// Use @Service annotation
// Throw an ProductException When Product is not found with message "Product with Id Does not Exist"
// Throw an ProductException When Product already exists with message "Product with Id already exists"

import com.learn.app.demorestapi.exception.ProductException;
import com.learn.app.demorestapi.model.Product;
import com.learn.app.demorestapi.respository.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            return product.get();
        } else {
            throw new ProductException("Product with Id Does not Exist");
        }
    }

    @Override
    public Product addProduct(Product product) {
        Optional<Product> product1 = productRepository.findById(product.getId());
        if(product1.isPresent()) {
            throw new ProductException("Product with Id already exists");
        } else {
            return productRepository.save(product);
        }
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> product1 = productRepository.findById(product.getId());
        if(product1.isPresent()) {
            return productRepository.save(product);
        } else {
            throw new ProductException();
        }
    }

    @Override
    public void deleteProduct(String id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new ProductException();
        }
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByPriceRange(double min, double max) {
        return productRepository.findByPriceBetween(min, max);
    }
}


