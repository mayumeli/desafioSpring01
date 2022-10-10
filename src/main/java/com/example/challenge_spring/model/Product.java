package com.example.challenge_spring.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    private int productId;

    @NotBlank
    @Size(min = 3, max = 20)
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "Permitido apenas letras")
    // @Pattern(regexp = "[a-zA-Z0-9\\s]+", message = "Permitido apenas letras e números")
    private String name;

    @NotBlank
    @Size(min = 3, max = 20)
    private String category;

    @NotBlank
    @Size(min = 3, max = 20)
    private String brand;

    @NotNull
    @Digits(integer = 5, fraction = 2)
    @PositiveOrZero
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
