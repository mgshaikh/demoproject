package com.learn.app.demorestapi.controller;

// Create JNUIT5 Test cases for testing the ProductController endpoints
// Use MockMVC to test the endpoints
// Use @WebMvcTest annotation
// Use @MockBean annotation to mock the ProductService
// Write postive and negative test cases for each endpoint
// Use @BeforeEach and @AfterEach annotations to setup and teardown the test data

import com.learn.app.demorestapi.model.Product;
import com.learn.app.demorestapi.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ProductController.class)
public class ProductControllerTest{

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    List<Product> products;

    @BeforeEach
    public void setup() {
        products = new ArrayList<>();
        products.add(new Product("1", "Product1", 100.0, "Category1"));
        products.add(new Product("2", "Product2", 200.0, "Category2"));
        products.add(new Product("3", "Product3", 300.0, "Category3"));
    }

    @AfterEach
    public void tearDown() {
        products = null;
    }

    @Test
    public void testGetAllProducts() throws Exception {
        Mockito.when(productService.getAllProducts()).thenReturn(products);
        String url = "/api/products";
        String response = mockMvc.perform(MockMvcRequestBuilders.get(url)).andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(response, products.toString());
    }

    @Test
    public void testGetProductById() throws Exception {
        Mockito.when(productService.getProductById("1")).thenReturn(products.get(0));
        String url = "/api/products/1";
        String response = mockMvc.perform(MockMvcRequestBuilders.get(url)).andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(response, products.get(0).toString());
    }

    @Test
    public void testGetProductByIdNotFound() throws Exception {
        Mockito.when(productService.getProductById("4")).thenReturn(null);
        String url = "/api/products/4";
        String response = mockMvc.perform(MockMvcRequestBuilders.get(url)).andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(response, "");
    }

    @Test
    public void testAddProduct() throws Exception {
        Product product = new Product("4", "Product4",  400.0, "Category4");
        Mockito.when(productService.addProduct(product)).thenReturn(product);
        String url = "/api/products";
        String response = mockMvc.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON).content(product.toString())).andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(response, product.toString());
    }

    @Test
    public void testUpdateProduct() throws Exception {
        Product product = new Product("4", "Product4",  400.0, "Category4");
        Mockito.when(productService.updateProduct(product)).thenReturn(product);
        String url = "/api/products";
        String response = mockMvc.perform(MockMvcRequestBuilders.put(url).contentType(MediaType.APPLICATION_JSON).content
        (product.toString())).andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(response, product.toString());


}
}
