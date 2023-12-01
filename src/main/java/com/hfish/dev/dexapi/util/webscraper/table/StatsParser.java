package com.hfish.dev.dexapi.util.webscraper.table;

import com.hfish.dev.dexapi.model.pokemon.Stats;
import com.hfish.dev.dexapi.util.webscraper.parent.HtmlTableParser;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author haydenfish
 * @version 11.30.2023
 */

@Component
public class StatsParser extends HtmlTableParser {
    // index variables represent the index of specified data piece in attribute list
    private final static int hpIndex = 4;
    private final static int attackIndex = 5;
    private final static int defenseIndex = 6;
    private final static int spatkIndex = 7;
    private final static int spdefIndex = 8;
    private final static int speedIndex = 9;

    /**
     *
     * @param thePokemonName name of the pokemon to find stats information for
     * @return Stats object containing the data parsed from html table, null if unable to locate
     */
    public Stats findStats(String thePokemonName) {
        return (Stats) parseModelElement(1, thePokemonName, Stats.resourceUrl);
    }

    @Override
    protected Stats mapElementToModel(ArrayList<Element> theAttributeList) {
        // map elements in the attribute list to corresponding object fields
        int hp = Integer.parseInt(theAttributeList.get(hpIndex).text());
        int atk = Integer.parseInt(theAttributeList.get(attackIndex).text());
        int def = Integer.parseInt(theAttributeList.get(defenseIndex).text());
        int spatk = Integer.parseInt(theAttributeList.get(spatkIndex).text());
        int spdef = Integer.parseInt(theAttributeList.get(spdefIndex).text());
        int speed = Integer.parseInt(theAttributeList.get(speedIndex).text());

        return new Stats(hp, atk, def, spatk, spdef, speed);
    }
}
