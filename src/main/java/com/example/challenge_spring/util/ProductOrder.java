package com.example.challenge_spring.util;

import com.example.challenge_spring.model.Product;

public class ProductOrder {

    public static int orderProducts(int order, Product p1, Product p2) {
        if (order == 0) return alphabeticalOrder(p1, p2);
        if (order == 1) return alphabeticalOrder(p2, p1);
        return 0;
    }

    private static int alphabeticalOrder(Product p1, Product p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
