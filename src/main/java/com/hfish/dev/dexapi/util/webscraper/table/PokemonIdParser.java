package com.hfish.dev.dexapi.util.webscraper.table;

import com.hfish.dev.dexapi.model.pokemon.PokemonId;
import com.hfish.dev.dexapi.util.webscraper.parent.HtmlTableParser;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PokemonIdParser extends HtmlTableParser {
    private final static int idIndex = 0;

    public PokemonId findPokemonId(String thePokemonName) {
        return (PokemonId) parseModelElement(1, thePokemonName, PokemonId.resourceUrl);
    }

    @Override
    protected PokemonId mapElementToModel(ArrayList<Element> theAttributeList) {
        return new PokemonId(theAttributeList.get(idIndex).text());
    }
}
