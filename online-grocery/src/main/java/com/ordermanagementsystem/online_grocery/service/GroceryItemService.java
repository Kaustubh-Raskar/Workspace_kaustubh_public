package com.ordermanagementsystem.online_grocery.service;

import java.util.List;

import com.ordermanagementsystem.online_grocery.model.GroceryItem;

public interface GroceryItemService {
    List<GroceryItem> getAllItems();
    GroceryItem getItemById(Long id);
    GroceryItem createItem(GroceryItem item);
    GroceryItem updateItem(Long id, GroceryItem updatedItem);
    void deleteItem(Long id);
}

