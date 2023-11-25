package com.hfish.dev.dexapi.model.item;

import com.hfish.dev.dexapi.util.ApiResource;

/**
 * @author haydenfish
 * @version 11.24.2023
 */

public class KeyItem implements ApiResource {
    private String name;
    private String effect;
    private final static String resourceUrl = "https://pokemondb.net/item/type/key";

    public KeyItem(String name, String effect) {
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
        return "KeyItem{" +
                "name='" + name + '\'' +
                ", effect='" + effect + '\'' +
                '}';
    }

    @Override
    public String getResourceUrl() {
        return resourceUrl;
    }
}
