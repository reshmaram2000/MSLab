package com.example.Hotel.service;

import com.example.Hotel.model.Item;
import com.example.Hotel.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItem(String itemID) {
        return itemRepository.findById(itemID).orElse(null);
    }


    public Item create(Item item) {
        return itemRepository.save(item);
    }

    public void delete(String itemId) {
        itemRepository.deleteById(itemId);
    }

    public Item update(Item item,String itemId) {
       Item item1 = itemRepository.findById(itemId).get();
        item1.setStatus(item.getStatus());
        item1.setLocation(item.getLocation());
        item1.setPincode(item.getPincode());
        item1.setDeliveryMode(item.getDeliveryMode());
        itemRepository.save(item1);
        return item1;
    }

    public void deleteAll() {
        itemRepository.deleteAll();
    }
}
