package com.hfish.dev.dexapi.parser;

import com.hfish.dev.dexapi.model.pokemon.Pokemon;
import com.hfish.dev.dexapi.util.webscraper.table.PokemonParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PokemonParserTests {
    @Autowired
    PokemonParser pokemonParser;
    @Test
    public void testFindByName() {
        Pokemon expectedPokemon = pokemonParser.findByName("Bulbasaur");

        Pokemon actualPokemon = pokemonParser.findByName("Bulbasaur");

        assertInstanceOf(Pokemon.class, actualPokemon);

        assertEquals(expectedPokemon.getNationalId(), actualPokemon.getNationalId());
        assertEquals(expectedPokemon.getName(), actualPokemon.getName());
        assertEquals(expectedPokemon.getTypes().size(), actualPokemon.getTypes().size());
        assertEquals(expectedPokemon.getStats().getTotal(), actualPokemon.getStats().getTotal());

        assertNull(pokemonParser.findByName(""));
        assertNull(pokemonParser.findByName("abc"));
    }
}
