package com.hfish.dev.dexapi.util.webscraper.table;

import com.hfish.dev.dexapi.model.pokemon.PokemonId;
import com.hfish.dev.dexapi.util.webscraper.parent.HtmlTableParser;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PokemonIdParser extends HtmlTableParser {
    // index variables represent the index of specified data piece in attribute list
    private final static int idIndex = 0;

    public PokemonId findByName(String thePokemonName) {
        return (PokemonId) parseModelElement(1, thePokemonName, PokemonId.resourceUrl);
    }

    @Override
    protected PokemonId mapElementToModel(ArrayList<Element> theAttributeList) {
        return new PokemonId(theAttributeList.get(idIndex).text());
    }
}
