package com.hfish.dev.dexapi.util.webscraper;

import com.hfish.dev.dexapi.model.enums.Category;
import com.hfish.dev.dexapi.model.item.Item;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author haydenfish
 * @version 11.24.2023
 */

@Component
public class ItemParser extends HtmlParser {
    /**
     * Establishes jsoup connection to item resource url, and parses html data for the required attributes
     *
     * @param theName name of the item we are searching for
     * @return an item with corresponding name field
     */
    public Item find(String theName) {
        return parseItemElement(theName);
    }

    private Item parseItemElement(String theItemName) {
        ArrayList<Element> attributeList = new ArrayList<>();

        Document doc = connect(Item.resourceUrl);

        Element table = doc.select("table").first();
        Elements rows = table.select("tr");

        for(int i = 1; i < rows.size(); i++) {
            Element currentElement = rows.get(i);

            if (currentElement.text().contains(theItemName)) {
                attributeList = currentElement.select("td");
            }
        }

        return verifyItemExists(attributeList, theItemName) ? mapElementToItem(attributeList): null;
    }

    private Item mapElementToItem(ArrayList<Element> theElements) {
         return new Item(theElements.get(0).text(),
                Category.valueOfLabel(theElements.get(1).text()),
                theElements.get(2).text());
    }

    private boolean verifyItemExists(ArrayList<Element> theElements, String theItemName) {
        return theElements.get(0).text().equals(theItemName);
    }
}
