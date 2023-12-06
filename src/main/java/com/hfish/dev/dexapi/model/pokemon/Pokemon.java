package com.hfish.dev.dexapi.model.pokemon;

import com.hfish.dev.dexapi.model.enums.Type;
import com.hfish.dev.dexapi.util.ApiResource;

import java.util.HashMap;
import java.util.List;

/**
 * @author haydenfish
 * @version 11.24.2023
 */

public class Pokemon implements ApiResource {
    private int nationalId;
    private String name;
    private List<Type> types;
    private Stats stats;

    public final static String resourceUrl = "https://pokemondb.net/pokedex/all";

    public Pokemon(int nationalId, String name, List<Type> types, Stats stats) {
        this.nationalId = nationalId;
        this.name = name;
        this.types = types;
        this.stats = stats;
    }

    public int getNationalId() {
        return nationalId;
    }

    public String getName() {
        return name;
    }

    public List<Type> getTypes() {
        return types;
    }

    public Stats getStats() {
        return stats;
    }

    @Override
    public String getResourceUrl() {
        return resourceUrl;
    }
}
