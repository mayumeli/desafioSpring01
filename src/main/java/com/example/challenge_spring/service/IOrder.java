package com.example.challenge_spring.service;

import com.example.challenge_spring.dto.OrderDto;
import com.example.challenge_spring.model.Ticket;

public interface IOrder {
    Ticket createPurchase(OrderDto order);
}
