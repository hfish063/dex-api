package com.hfish.dev.dexapi.model.pokemon;

import com.hfish.dev.dexapi.util.ApiResource;

/**
 * @author haydenfish
 * @version 11.24.2023
 */

public class Sprite implements ApiResource {
    private int generation;
    private String pokemonName;
    private boolean shiny;
    private String imgSrcUrl;
    public final static String resourceUrl = "https://pokemondb.net/sprites/";

    public Sprite(int generation,String pokemonName, boolean shiny, String imgSrcUrl) {
        this.generation = generation;
        this.pokemonName = pokemonName;
        this.shiny = shiny;
        this.imgSrcUrl = imgSrcUrl;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public boolean isShiny() {
        return shiny;
    }

    public void setShiny(boolean shiny) {
        this.shiny = shiny;
    }

    public String getImgSrcUrl() {
        return imgSrcUrl;
    }

    public void setImgSrcUrl(String imgSrcUrl) {
        this.imgSrcUrl = imgSrcUrl;
    }

    @Override
    public String toString() {
        return "Sprite{" +
                "generation=" + generation +
                ", shiny=" + shiny +
                ", imgSrcUrl='" + imgSrcUrl + '\'' +
                '}';
    }

    @Override
    public String getResourceUrl() {
        return resourceUrl;
    }
}
