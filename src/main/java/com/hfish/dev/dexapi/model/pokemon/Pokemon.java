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
    // required fields
    private final int nationalId;
    private final String name;

    // optional fields
    private List<Type> types;
    private String species;
    private double height;
    private double weight;

    private List<Ability> abilities;
    private HashMap<Integer, String> localId;
    private final static String resourceUrl = "https://pokemondb.net/pokedex/";

    public int getNationalId() {
        return nationalId;
    }

    public String getName() {
        return name;
    }

    public List<Type> getTypes() {
        return types;
    }

    public String getSpecies() {
        return species;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public HashMap<Integer, String> getLocalId() {
        return localId;
    }

    private Pokemon(PokemonBuilder pokemonBuilder) {
        this.nationalId = pokemonBuilder.nationalId;
        this.name = pokemonBuilder.name;
    }

    @Override
    public String getResourceUrl() {
        return resourceUrl;
    }

    public static class PokemonBuilder {
        // required fields
        private int nationalId;
        private String name;

        // optional fields
        private List<Type> types;
        private String species;
        private double height;
        private double weight;
        private List<Ability> abilities;
        private HashMap<Integer, String> localId;

        public PokemonBuilder(int nationalId, String name) {
            this.nationalId = nationalId;
            this.name = name;
        }

        public PokemonBuilder setTypes(List<Type> types) {
            this.types = types;
            return this;
        }

        public PokemonBuilder setSpecies(String species) {
            this.species = species;
            return this;
        }

        public PokemonBuilder setHeight(double height) {
            this.height = height;
            return this;
        }

        public PokemonBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public PokemonBuilder setAbilities(List<Ability> abilities) {
            this.abilities = abilities;
            return this;
        }

        public PokemonBuilder setLocalId(HashMap<Integer, String> localId) {
            this.localId = localId;
            return this;
        }

        public Pokemon build() {
            return new Pokemon(this);
        }
    }
}
