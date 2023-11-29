package com.hfish.dev.dexapi.service.item;

import com.hfish.dev.dexapi.model.item.Item;
import com.hfish.dev.dexapi.model.item.KeyItem;

import java.util.List;

public interface ItemService {
    public Item findItem(String theItemName);

    public KeyItem findKeyItem(String theKeyItemName);
}
