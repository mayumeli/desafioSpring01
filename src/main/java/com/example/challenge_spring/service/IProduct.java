package com.example.challenge_spring.service;

import com.example.challenge_spring.dto.ProductDto;
import com.example.challenge_spring.model.Product;

import java.io.IOException;
import java.util.List;

public interface IProduct {
    List<ProductDto> createProduct(List<Product> products) throws IOException;
    List<Product> getAllByCategory(String category);

    List<Product> getAll();
}
