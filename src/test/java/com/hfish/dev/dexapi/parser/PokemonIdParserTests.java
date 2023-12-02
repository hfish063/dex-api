package com.hfish.dev.dexapi.parser;

import com.hfish.dev.dexapi.model.pokemon.PokemonId;
import com.hfish.dev.dexapi.util.webscraper.table.PokemonIdParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PokemonIdParserTests {
    @Autowired
    PokemonIdParser pokemonIdParser;

    @Test
    public void testFindPokemonId() {
        PokemonId expectedId = new PokemonId("0001");
        PokemonId actualId = pokemonIdParser.findByName("Bulbasaur");

        assertInstanceOf(PokemonId.class, actualId);

        assertEquals(expectedId.getId(), actualId.getId());

        assertNull(pokemonIdParser.findByName(""));
    }
}
