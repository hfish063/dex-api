package com.hfish.dev.dexapi.model.pokemon;

import com.hfish.dev.dexapi.util.ApiResource;

public class Ability implements ApiResource {
    private String name;
    private boolean hidden;
    private String effect;
    public final static String resourceUrl = "https://pokemondb.net/ability";

    public Ability(String name, boolean hidden, String effect) {
        this.name = name;
        this.hidden = hidden;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
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
                ", hidden=" + hidden +
                ", effect='" + effect + '\'' +
                '}';
    }

    @Override
    public String getResourceUrl() {
        return resourceUrl;
    }
}
