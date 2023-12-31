package com.hfish.dev.dexapi.util.webscraper.table;

import com.hfish.dev.dexapi.model.enums.Category;
import com.hfish.dev.dexapi.model.item.Item;
import com.hfish.dev.dexapi.util.webscraper.parent.HtmlTableParser;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author haydenfish
 * @version 11.28.2023
 */

@Component
public class ItemParser extends HtmlTableParser {
    // index variables represent the index of specified data piece in attribute list
    private final static int nameIndex = 0;
    private final static int categoryIndex = 1;
    private final static int descriptionIndex = 2;

    /**
     * Establishes jsoup connection to item resource url, and parses html data for the required attributes
     * If item with matching keyword is not found, return null
     *
     * @param theName name of the item we are searching for
     * @return an item with corresponding name field, null if not found
     */
    public Item findByName(String theName) {
        return (Item) parseModelElement(0, theName, Item.resourceUrl);
    }

    @Override
    protected Item mapElementToModel(ArrayList<Element> theAttributeList) {
         String itemName = theAttributeList.get(nameIndex).text();
         String categoryLabel = theAttributeList.get(categoryIndex).text();
         Category itemCategory = Category.valueOfLabel(categoryLabel);
         String itemDescription = theAttributeList.get(descriptionIndex).text();

         return new Item(itemName, itemCategory, itemDescription);
    }
}
