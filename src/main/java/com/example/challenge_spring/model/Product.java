package com.example.challenge_spring.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    private int productId;

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotBlank
    @Size(min = 3, max = 20)
    private String category;

    @NotBlank
    @Size(min = 3, max = 20)
    private String brand;

    @NotNull
    @Digits(integer = 5, fraction = 2)
    private Double price;

    @NotNull
    private Integer quantity;

    @NotNull
    private boolean freeShipping;

    @NotBlank
    private String prestige;

    public Product(String name, String category, String brand, double price, int quantity, boolean freeShipping, String prestige) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.freeShipping = freeShipping;
        this.prestige = prestige;
    }
}
