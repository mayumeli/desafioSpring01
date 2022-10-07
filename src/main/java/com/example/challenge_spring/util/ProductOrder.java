package com.example.challenge_spring.util;

import com.example.challenge_spring.model.Product;

// Classe utilitária para aplicar possíveis ordenações ao resultado das buscas.
public class ProductOrder {

    public static int orderProducts(int order, Product p1, Product p2) {
        if (order == 0) return alphabeticalOrder(p1, p2);
        if (order == 1) return alphabeticalOrder(p2, p1); // Ordenação inversa
        if (order == 2) return valueOrder(p2, p1);
        if (order == 3) return valueOrder(p1, p2); // Ordenação inversa
        return 0;
    }

    private static int alphabeticalOrder(Product p1, Product p2) {
        return p1.getName().compareTo(p2.getName());
    }

    private static int valueOrder(Product p1, Product p2){
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}
