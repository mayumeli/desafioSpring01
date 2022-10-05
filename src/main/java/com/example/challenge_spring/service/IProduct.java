package com.example.challenge_spring.service;

import com.example.challenge_spring.dto.ProductDto;
import com.example.challenge_spring.model.Product;

import java.io.IOException;
import java.util.List;

public interface IProduct {
    ProductDto createProduct(Product product) throws IOException;

    List<Product> getAll();
}
