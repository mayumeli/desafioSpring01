package com.example.challenge_spring.dto;

import com.example.challenge_spring.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
public class ProductDto implements Serializable {
    private int productId;
    private String name;
    private int quantity;

    public ProductDto(Product product){
        this.productId = product.getProductId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
    }

}
