package com.example.challenge_spring.service;

import com.example.challenge_spring.dto.ProductDto;
import com.example.challenge_spring.model.Product;

import java.io.IOException;

public interface IProduct {
    ProductDto createProduct(Product product) throws IOException;
}
