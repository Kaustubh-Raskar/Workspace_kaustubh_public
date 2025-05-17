package com.ordermanagementsystem.online_grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordermanagementsystem.online_grocery.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}

