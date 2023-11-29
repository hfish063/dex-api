package com.hfish.dev.dexapi.util.webscraper;

import com.hfish.dev.dexapi.model.enums.Category;
import com.hfish.dev.dexapi.model.item.Item;
import com.hfish.dev.dexapi.util.webscraper.parent.HtmlParser;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author haydenfish
 * @version 11.28.2023
 */

@Component
public class ItemParser extends HtmlParser {
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
    public Item findItem(String theName) {
        return (Item) parseModelElement(theName, Item.resourceUrl);
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
