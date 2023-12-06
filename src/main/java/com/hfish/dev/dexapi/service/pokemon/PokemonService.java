package com.hfish.dev.dexapi.service.pokemon;

import com.hfish.dev.dexapi.model.pokemon.Pokemon;

/**
 * @author haydenfish
 * @version 12.06.2023
 */

public interface PokemonService {
    public Pokemon findPokemon(String thePokemonName);
}
