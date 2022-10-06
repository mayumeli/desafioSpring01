package com.example.challenge_spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.challenge_spring.dto.OrderDto;
import com.example.challenge_spring.model.Product;
import com.example.challenge_spring.model.Ticket;
import com.example.challenge_spring.repository.ProductRepo;

@Service
public class OrderService implements IOrder{

    @Autowired
    private ProductRepo repository;

    @Override
    public Ticket createPurchase(OrderDto order) {
        List<Product> products = repository.getAll();

        Map<Integer, Product> mapProducts = products.stream().collect(Collectors.toMap(Product::getProductId, product -> product));

        Ticket ticket = new Ticket();

        List<Product> productsRequest = new ArrayList<>();
        order.getArticlesPurchaseRequest().stream().forEach(p -> {
            Product currentProduct = mapProducts.get(p.getProductId());
            currentProduct.setQuantity(p.getQuantity());
            productsRequest.add(currentProduct);
            ticket.setTotalPurchase(currentProduct.getPrice() * currentProduct.getQuantity());
        });

        ticket.setArticles(productsRequest);
        ticket.setId((int)Math.random() * 100);
        
        return ticket;
    }
}
