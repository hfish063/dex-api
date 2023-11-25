package com.hfish.dev.dexapi.model.pokemon;

import com.hfish.dev.dexapi.model.enums.Type;
import com.hfish.dev.dexapi.util.ApiResource;

/**
 * @author haydenfish
 * @version 11.24.2023
 */

public class Move implements ApiResource {
    private int generation;
    private String name;
    private Type type;
    private String effect;
    private final static String resourceUrl = "https://pokemondb.net/move/generation/";

    public Move(int generation, String name, Type type, String effect) {
        this.generation = generation;
        this.name = name;
        this.type = type;
        this.effect = effect;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    @Override
    public String toString() {
        return "Move{" +
                "generation=" + generation +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", effect='" + effect + '\'' +
                '}';
    }

    @Override
    public String getResourceUrl() {
        return resourceUrl;
    }
}
