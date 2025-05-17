package com.ordermanagementsystem.online_grocery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroceryItem {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String category;
    private Double price;
    private Integer quantity;
}
