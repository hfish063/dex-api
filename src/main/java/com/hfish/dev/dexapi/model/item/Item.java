package com.hfish.dev.dexapi.model.item;

import com.hfish.dev.dexapi.model.enums.Category;
import com.hfish.dev.dexapi.util.ApiResource;

/**
 * @author haydenfish
 * @version 11.24.2023
 */

public class Item implements ApiResource {
    private String name;
    private Category category;
    private String effect;
    public final static String resourceUrl = "https://pokemondb.net/item/all";

    public Item(String name, Category category, String effect) {
        this.name = name;
        this.category = category;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", effect='" + effect + '\'' +
                '}';
    }

    @Override
    public String getResourceUrl() {
        return resourceUrl;
    }
}
