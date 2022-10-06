package com.example.challenge_spring.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private int id;
    private List<Product> articles;
    private double total;

    public void setTotalPurchase(double price) {
        this.total = total + price;
    }
}
