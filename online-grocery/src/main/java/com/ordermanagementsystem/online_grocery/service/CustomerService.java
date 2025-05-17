package com.ordermanagementsystem.online_grocery.service;

import java.util.List;
import com.ordermanagementsystem.online_grocery.model.Customer;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer customerDetails);
    void deleteCustomer(Long id);
}
