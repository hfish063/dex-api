package com.hfish.dev.dexapi.controller;

import com.hfish.dev.dexapi.model.item.Item;
import com.hfish.dev.dexapi.model.item.KeyItem;
import com.hfish.dev.dexapi.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haydenfish
 * @version 11.24.2023
 */

@RestController
@RequestMapping("/api")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/item/{itemName}")
    public Item findItem(@PathVariable("itemName") String theItemName) {
        return itemService.findItem(theItemName);
    }

    @GetMapping("/keyItem/{keyItemName}")
    public KeyItem findKeyItem(@PathVariable("keyItemName") String theKeyItemName) {
        return itemService.findKeyItem(theKeyItemName);
    }
}
