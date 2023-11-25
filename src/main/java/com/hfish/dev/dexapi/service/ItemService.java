package com.hfish.dev.dexapi.service;

import com.hfish.dev.dexapi.model.item.Item;
import com.hfish.dev.dexapi.model.item.KeyItem;

public interface ItemService {
    public Item findItem(String theItemName);

    public KeyItem findKeyItem(String theKeyItemName);
}
