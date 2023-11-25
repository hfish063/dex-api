package com.hfish.dev.dexapi;

import com.hfish.dev.dexapi.model.enums.Category;
import com.hfish.dev.dexapi.model.item.Item;
import com.hfish.dev.dexapi.model.item.KeyItem;
import com.hfish.dev.dexapi.service.ItemService;
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

        assertNull(itemService.findItem(""));

        assertThrows(Exception.class, () -> itemService.findItem("abc"));
    }

    @Test
    public void testFindKeyItem() {

    }
}
