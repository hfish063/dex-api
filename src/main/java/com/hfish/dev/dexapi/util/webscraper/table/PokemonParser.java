package com.hfish.dev.dexapi.util.webscraper.table;

import com.hfish.dev.dexapi.model.enums.Type;
import com.hfish.dev.dexapi.model.pokemon.Pokemon;
import com.hfish.dev.dexapi.model.pokemon.Stats;
import com.hfish.dev.dexapi.util.webscraper.parent.HtmlTableParser;
import com.hfish.dev.dexapi.util.webscraper.table.PokemonIdParser;
import com.hfish.dev.dexapi.util.webscraper.table.StatsParser;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haydenfish
 * @version 12.05.2023
 */

@Component
public class PokemonParser extends HtmlTableParser {
    private StatsParser statsParser;
    private PokemonIdParser idParser;

    @Autowired
    public PokemonParser(StatsParser statsParser) {
        this.statsParser = statsParser;
    }

    /**
     * Parses html document at Pokemon resourceUrl, searches for Pokemon with matching name and returns if found,
     * otherwise will return null to indicate Pokemon does not exist
     *
     * @param thePokemonName name of the Pokemon to search for
     * @return Corresponding Pokemon object if found, null otherwise
     */
    public Pokemon findByName(String thePokemonName) {
        return (Pokemon) parseModelElement(1, thePokemonName, Pokemon.resourceUrl);
    }

    @Override
    protected Pokemon mapElementToModel(ArrayList<Element> theAttributeList) {
        int pokemonId = Integer.parseInt(theAttributeList.get(0).text());
        String pokemonName = theAttributeList.get(1).text();

        // important: capitalize and split type String into a list, so that it can be matched to enum
        String typeString = theAttributeList.get(2).text().toUpperCase();
        String[] t = typeString.split(" ");
        List<Type> typeList = new ArrayList<>();

        for(String type : t) {
            typeList.add(Type.valueOf(type));
        }

        Stats pokemonStats = statsParser.findByName(pokemonName);

        return new Pokemon(pokemonId, pokemonName, typeList, pokemonStats);
    }
}
