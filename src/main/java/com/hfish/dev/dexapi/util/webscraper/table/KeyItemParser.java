package com.hfish.dev.dexapi.util.webscraper.table;

import com.hfish.dev.dexapi.model.item.KeyItem;
import com.hfish.dev.dexapi.util.webscraper.parent.HtmlTableParser;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author haydenfish
 * @version 11.28.2023
 */

@Component
public class KeyItemParser extends HtmlTableParser {
    private static final int nameIndex = 0;
    private static final int descriptionIndex = 1;

    /**
     * Parses html data for required attributes
     * If KeyItem with matching name is not found, return null
     *
     * @param theName name of the key item we are searching for
     * @return a key item object with corresponding name field, null if not found
     */
    public KeyItem findKeyItem(String theName) {
        return (KeyItem) parseModelElement(0, theName, KeyItem.resourceUrl);
    }

    @Override
    protected KeyItem mapElementToModel(ArrayList<Element> theAttributeList) {
        String keyItemName = theAttributeList.get(nameIndex).text();
        String keyItemDescription = theAttributeList.get(descriptionIndex).text();

        return new KeyItem(keyItemName, keyItemDescription);
    }
}
