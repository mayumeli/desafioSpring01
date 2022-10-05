package com.example.challenge_spring.model;

public class Produto {

    private int produtcId;
    private String name;
    private String category;
    private String brand;
    private double price;
    private int quantity;
    private boolean freeShipping;
    private String prestige;

    public Produto(int produtcId, String name, String category, String brand, double price, int quantity, boolean freeShipping, String prestige) {
        this.produtcId = produtcId;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.freeShipping = freeShipping;
        this.prestige = prestige;
    }
}
