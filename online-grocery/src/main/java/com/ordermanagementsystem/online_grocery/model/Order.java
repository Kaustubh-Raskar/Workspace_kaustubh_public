package com.ordermanagementsystem.online_grocery.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Order {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<GroceryItem> items;

    private LocalDate orderDate;
    private Double totalPrice;
}
