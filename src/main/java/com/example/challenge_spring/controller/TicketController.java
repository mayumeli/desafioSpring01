package com.example.challenge_spring.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.challenge_spring.dto.OrderDto;
import com.example.challenge_spring.model.Ticket;
import com.example.challenge_spring.service.IOrder;

@RestController
@RequestMapping("/api/v1")
public class TicketController {
    
    @Autowired
    private IOrder service;
    @PostMapping("/purchase-request")
    public ResponseEntity<Ticket> createProduct(@RequestBody OrderDto order) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPurchase(order));
    }
}
