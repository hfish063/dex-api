package com.hfish.dev.dexapi.service.item;

import com.hfish.dev.dexapi.exception.NoModelFoundException;
import com.hfish.dev.dexapi.model.item.Item;
import com.hfish.dev.dexapi.model.item.KeyItem;
import com.hfish.dev.dexapi.util.webscraper.ItemParser;
import com.hfish.dev.dexapi.util.webscraper.KeyItemParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author haydenfish
 * @version 11.28.2023
 */

@Service
public class ItemServiceImpl implements ItemService{
    private ItemParser itemParser;
    private KeyItemParser keyItemParser;

    @Autowired
    public ItemServiceImpl(ItemParser itemParser, KeyItemParser keyItemParser) {
        this.itemParser = itemParser;
        this.keyItemParser = keyItemParser;
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
        Item result = itemParser.findItem(theItemName);

        if (result == null) {
            throw new NoModelFoundException();
        }

        return result;
    }

    /**
     * Parse html data at key item resource url, collect all required info to instantiate object
     *
     * @param theKeyItemName  key item name field, used as search param to find a specific entry
     * @return key item with corresponding name field
     */
    @Override
    public KeyItem findKeyItem(String theKeyItemName) {
        KeyItem result = keyItemParser.findKeyItem(theKeyItemName);

        if (result == null) {
            throw new NoModelFoundException();
        }

        return result;
    }
}
