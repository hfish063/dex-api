package com.hfish.dev.dexapi.service.sprite;

import com.hfish.dev.dexapi.model.pokemon.Sprite;

public interface SpriteService {
    public Sprite findNormalSprite(int theGeneration, String thePokemonName);

    public Sprite findShinySprite(int theGeneration, String thePokemonName);
}
