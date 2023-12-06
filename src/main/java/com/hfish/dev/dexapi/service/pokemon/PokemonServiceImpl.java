package com.hfish.dev.dexapi.service.pokemon;

import com.hfish.dev.dexapi.exception.NoModelFoundException;
import com.hfish.dev.dexapi.model.pokemon.Pokemon;
import com.hfish.dev.dexapi.util.webscraper.parent.HtmlTableParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author haydenfish
 * @version 12.06.2023
 */

@Service
public class PokemonServiceImpl implements PokemonService {
    private HtmlTableParser pokemonParser;

    @Autowired
    public PokemonServiceImpl(HtmlTableParser pokemonParser) {
        this.pokemonParser = pokemonParser;
    }

    /**
     * Searches for pokemon with corresponding name, throwing NoModelFoundException if unable to locate
     * If user enters valid pokemon name, we should always return a corresponding object
     *
     * @param thePokemonName name field of the pokemon we are searching for
     * @return Pokemon object if found, throw exception otherwise
     */
    @Override
    public Pokemon findPokemon(String thePokemonName) {
        Optional<Pokemon> result = Optional.ofNullable((Pokemon) pokemonParser.findByName(thePokemonName));

        if (result.isEmpty()) {
            throw new NoModelFoundException("Could not locate pokemon with name - " + thePokemonName);
        }

        return result.get();
    }
}
