package com.hfish.dev.dexapi.model.pokemon;

import com.hfish.dev.dexapi.util.ApiResource;

/**
 * @author haydenfish
 * @version 11.24.2023
 */

public class Sprite implements ApiResource {
    private int generation;
    private boolean shiny;
    private String imgSrcUrl;
    private final static String resourceUrl = "https://pokemondb.net/sprites/";

    public Sprite(int generation, boolean shiny, String imgSrcUrl) {
        this.generation = generation;
        this.shiny = shiny;
        this.imgSrcUrl = imgSrcUrl;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
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
