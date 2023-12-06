package com.hfish.dev.dexapi.model.pokemon;

import com.hfish.dev.dexapi.util.ApiResource;

public class Ability implements ApiResource {
    private String name;
    private String effect;
    public final static String resourceUrl = "https://pokemondb.net/ability";

    public Ability(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "name='" + name + '\'' +
                ", effect='" + effect + '\'' +
                '}';
    }

    @Override
    public String getResourceUrl() {
        return resourceUrl;
    }
}
