package com.learn.app.demorestapi.model;

// Create a entity class Product with properties id, name, price, category
// Use Lombok annotations to generate getters and setters, constructors, toString() method
// Use Spring Data Mongo to persist data to MongoDB

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private String category;
}