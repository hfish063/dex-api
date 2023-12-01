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
    private final static int hpIndex = 4;
    private final static int attackIndex = 5;
    private final static int defenseIndex = 6;
    private final static int spatkIndex = 7;
    private final static int spdefIndex = 8;
    private final static int speedIndex = 9;

    public Stats findStats(String thePokemonName) {
        return (Stats) parseModelElement(1, thePokemonName, Stats.resourceUrl);
    }

    @Override
    protected Stats mapElementToModel(ArrayList<Element> theAttributeList) {
        int hp = Integer.parseInt(theAttributeList.get(hpIndex).text());
        int atk = Integer.parseInt(theAttributeList.get(attackIndex).text());
        int def = Integer.parseInt(theAttributeList.get(defenseIndex).text());
        int spatk = Integer.parseInt(theAttributeList.get(spatkIndex).text());
        int spdef = Integer.parseInt(theAttributeList.get(spdefIndex).text());
        int speed = Integer.parseInt(theAttributeList.get(speedIndex).text());

        return new Stats(hp, atk, def, spatk, spdef, speed);
    }
}
