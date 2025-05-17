package com.ordermanagementsystem.online_grocery.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagementsystem.online_grocery.model.Customer;
import com.ordermanagementsystem.online_grocery.model.GroceryItem;
import com.ordermanagementsystem.online_grocery.model.Order;
import com.ordermanagementsystem.online_grocery.repository.CustomerRepository;
import com.ordermanagementsystem.online_grocery.repository.GroceryItemRepository;
import com.ordermanagementsystem.online_grocery.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private GroceryItemRepository itemRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Order createOrder(Order order) {
        // Ensure customer exists
        Customer customer = customerRepository.findById(order.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Validate and fetch each item
        List<GroceryItem> validatedItems = new ArrayList<>();
        for (GroceryItem item : order.getItems()) {
            GroceryItem dbItem = itemRepository.findById(item.getId())
                    .orElseThrow(() -> new RuntimeException("Item not found with ID: " + item.getId()));
            validatedItems.add(dbItem);
        }

        // Set details
        order.setCustomer(customer);
        order.setItems(validatedItems);
        order.setOrderDate(LocalDate.now());

        double total = validatedItems.stream().mapToDouble(GroceryItem::getPrice).sum();
        order.setTotalPrice(total);

        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(order);
    }

}
