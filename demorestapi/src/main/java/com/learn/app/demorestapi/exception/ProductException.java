package com.learn.app.demorestapi.exception;

// create a class ProductException that extends RuntimeException
// Use Exception message " Product with Id Does not Exist"

public class ProductException extends RuntimeException {

    private String message = "Product with Id Does not Exist";

    public ProductException() {
        super(); 
    }

    public ProductException(String message) {
        super(message);
    }
}


