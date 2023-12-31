package com.hfish.dev.dexapi.service;

import com.hfish.dev.dexapi.exception.NoModelFoundException;
import com.hfish.dev.dexapi.model.enums.Category;
import com.hfish.dev.dexapi.model.item.Item;
import com.hfish.dev.dexapi.model.item.KeyItem;
import com.hfish.dev.dexapi.service.item.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ItemServiceTests {
    @Autowired
    ItemService itemService;

    @Test
    public void testFindItem() {
        Item expectedItem = new Item("Antidote", Category.MEDICINE, "Cures a Pokémon of poisoning.");
        Item actualItem = itemService.findItem("Antidote");

        assertInstanceOf(Item.class, actualItem);

        assertEquals(expectedItem.getName(), actualItem.getName());
        assertEquals(expectedItem.getCategory(), actualItem.getCategory());
        assertEquals(expectedItem.getEffect(), actualItem.getEffect());

        assertThrows(NoModelFoundException.class, () -> {itemService.findItem("");});
        assertThrows(NoModelFoundException.class, () -> {itemService.findItem("abc");});
    }

    @Test
    public void testFindKeyItem() {
        KeyItem expectedKeyItem = new KeyItem(
                "Bike", "A folding Bike that enables a rider to get around much faster than with Running Shoes."
        );
        KeyItem actualKeyItem = itemService.findKeyItem("Bike");

        assertInstanceOf(KeyItem.class, actualKeyItem);

        assertEquals(expectedKeyItem.getName(), actualKeyItem.getName());
        assertEquals(expectedKeyItem.getEffect(), actualKeyItem.getEffect());

        assertThrows(NoModelFoundException.class, () -> {itemService.findKeyItem("");});
        assertThrows(NoModelFoundException.class, () -> {itemService.findKeyItem("abc");});
    }
}
