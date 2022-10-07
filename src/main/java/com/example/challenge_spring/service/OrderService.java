package com.example.challenge_spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.challenge_spring.dto.OrderDto;
import com.example.challenge_spring.exceptions.ProductNotFoundException;
import com.example.challenge_spring.model.Product;
import com.example.challenge_spring.model.Ticket;
import com.example.challenge_spring.repository.ProductRepo;

@Service
public class OrderService implements IOrder{

    @Autowired
    private ProductRepo repository;

    @Override
    public Ticket createPurchase(OrderDto order) {
        
        // Buscando produtos e armazenando em lista
        List<Product> products = repository.getAll();
        
        // Transformando lista de produtos em HashMap
        Map<Integer, Product> mapProducts = products.stream().collect(Collectors.toMap(Product::getProductId, product -> product));
 
        Ticket ticket = new Ticket();

        /*  
            ProductsRequest representa lista de produtos que a API irá responder para o usuário, a partir daí percorremos os produtos enviados, a fim de popular o nosso objeto de resposta Ticket com os dados do nosso arquivo.  
        */
        List<Product> productsRequest = new ArrayList<>();
        order.getArticlesPurchaseRequest().stream().forEach(p -> {
            Product currentProduct = mapProducts.get(p.getProductId());
            if (currentProduct == null) {
                throw new ProductNotFoundException("Produto não encontrado");
            }
            currentProduct.setQuantity(p.getQuantity());
            productsRequest.add(currentProduct);
            ticket.setTotalPurchase(currentProduct.getPrice() * currentProduct.getQuantity());
        });

        ticket.setArticles(productsRequest);
        ticket.setId((int)(Math.random() * 100));
        
        return ticket;
    }
}
