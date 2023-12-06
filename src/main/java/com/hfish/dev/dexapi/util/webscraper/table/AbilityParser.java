package com.hfish.dev.dexapi.util.webscraper.table;

import com.hfish.dev.dexapi.model.pokemon.Ability;
import com.hfish.dev.dexapi.util.webscraper.parent.HtmlTableParser;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author haydenfish
 * @version 12.05.2023
 */

@Component
public class AbilityParser extends HtmlTableParser {
    private final static int nameIndex = 0;
    private final static int descriptionIndex = 2;

    /** Parses html document provided by resourceUrl, searches for move data with corresponding name in the html table
     * located on page, returns Ability object with associated fields if found, null otherwise
     *
     * @param theName name of the element to search for
     * @return Ability object with data located in html table, null if ability was not found
     */
    @Override
    public Ability findByName(String theName) {
        return (Ability) parseModelElement(0, theName, Ability.resourceUrl);
    }

    @Override
    protected Ability mapElementToModel(ArrayList<Element> theAttributeList) {
        String abilityName = theAttributeList.get(0).text();
        String abilityDescription = theAttributeList.get(2).text();

        return new Ability(abilityName, false,abilityDescription);
    }
}
