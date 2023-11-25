package com.hfish.dev.dexapi.service;

import com.hfish.dev.dexapi.model.item.Item;
import com.hfish.dev.dexapi.model.item.KeyItem;
import com.hfish.dev.dexapi.util.webscraper.ItemParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author haydenfish
 * @version 11.24.2023
 */

@Service
public class ItemServiceImpl implements ItemService{
    private ItemParser itemParser;

    @Autowired
    public ItemServiceImpl(ItemParser itemParser) {
        this.itemParser = itemParser;
    }

    /**
     * Parse html data at item resource url with corresponding name, collect the required information to
     * instantiate an item object
     *
     * @param theItemName item name field, used as our search parameter to find specific entry
     * @return item object with corresponding name field
     */
    @Override
    public Item findItem(String theItemName) {
        return itemParser.find(theItemName);
    }

    /**
     * Parse html data at key item resource url, collect all required info to instantiate object
     *
     * @param theKeyItemName  key item name field, used as search param to find a specific entry
     * @return key item with corresponding name field
     */
    @Override
    public KeyItem findKeyItem(String theKeyItemName) {
        return null;
        //return itemParser.find(theKeyItemName);
    }
}
