package com.ordermanagementsystem.online_grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagementsystem.online_grocery.model.GroceryItem;
import com.ordermanagementsystem.online_grocery.repository.GroceryItemRepository;

@Service
public class GroceryItemServiceImpl implements GroceryItemService {

    @Autowired
    private GroceryItemRepository itemRepository;

    @Override
    public List<GroceryItem> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public GroceryItem getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    @Override
    public GroceryItem createItem(GroceryItem item) {
        return itemRepository.save(item);
    }

    @Override
    public GroceryItem updateItem(Long id, GroceryItem updatedItem) {
        GroceryItem item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        item.setName(updatedItem.getName());
        item.setCategory(updatedItem.getCategory());
        item.setPrice(updatedItem.getPrice());
        item.setQuantity(updatedItem.getQuantity());

        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        GroceryItem item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        itemRepository.delete(item);
    }
}
