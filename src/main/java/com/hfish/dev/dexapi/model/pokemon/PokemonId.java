package com.hfish.dev.dexapi.model.pokemon;

import com.hfish.dev.dexapi.util.ApiResource;

/**
 * @author haydenfish
 * @version 11.30.2023
 */

public class PokemonId implements ApiResource {
    private String id;
    public final static String resourceUrl = "https://pokemondb.net/pokedex/all";

    public PokemonId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PokemonId{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public String getResourceUrl() {
        return null;
    }
}
