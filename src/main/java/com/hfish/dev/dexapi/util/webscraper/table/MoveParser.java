package com.hfish.dev.dexapi.util.webscraper.table;

import com.hfish.dev.dexapi.model.enums.Type;
import com.hfish.dev.dexapi.model.pokemon.Move;
import com.hfish.dev.dexapi.util.webscraper.parent.HtmlTableParser;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author haydenfish
 * @version 11.29.2023
 */
@Component
public class MoveParser extends HtmlTableParser {
    // index variables represent the index of specified data piece in attribute list
    private final static int nameIndex = 0;
    private final static int typeIndex = 1;
    private final static int effectIndex = 6;

    /**
     * Parses html document at Move resourceUrl, searches for move with matching name and returns if found,
     * otherwise will return null to indicate move does not exist
     *
     * @param theMoveName name of the move to search for
     * @return Corresponding Move object if found, null otherwise
     */
    public Move findByName(String theMoveName) {
        return (Move) parseModelElement(0, theMoveName, Move.resourceUrl);
    }

    @Override
    protected Move mapElementToModel(ArrayList<Element> theAttributeList) {
        String moveName = theAttributeList.get(nameIndex).text();
        Type moveType = Type.valueOf(theAttributeList.get(typeIndex).text().toUpperCase());
        String moveEffect = theAttributeList.get(effectIndex).text();

        return new Move(1, moveName, moveType, moveEffect);
    }
}
