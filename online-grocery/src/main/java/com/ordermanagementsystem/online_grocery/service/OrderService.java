package com.ordermanagementsystem.online_grocery.service;

import java.util.List;

import com.ordermanagementsystem.online_grocery.model.Order;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(Order order);
    void deleteOrder(Long id);
}
