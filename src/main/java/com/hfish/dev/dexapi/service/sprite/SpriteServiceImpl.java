package com.hfish.dev.dexapi.service.sprite;

import com.hfish.dev.dexapi.exception.NoModelFoundException;
import com.hfish.dev.dexapi.model.pokemon.Sprite;
import com.hfish.dev.dexapi.util.webscraper.page.SpriteParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author haydenfish
 * @version 11.30.2023
 */

@Service
public class SpriteServiceImpl implements SpriteService {
    private SpriteParser spriteParser;

    @Autowired
    public SpriteServiceImpl(SpriteParser spriteParser) {
        this.spriteParser = spriteParser;
    }

    /**
     * @param theGeneration
     * @param thePokemonName
     * @return
     */
    @Override
    public Sprite findNormalSprite(int theGeneration, String thePokemonName) {
        Optional<Sprite> result = Optional.ofNullable(spriteParser.findSprite(theGeneration, thePokemonName, false));

        if (result.isEmpty()) {
            throw new NoModelFoundException("Could not locate Sprite for Pokemon - " + thePokemonName);
        }

        return result.get();
    }

    /**
     * @param theGeneration
     * @param thePokemonName
     * @return
     */
    @Override
    public Sprite findShinySprite(int theGeneration, String thePokemonName) {
        Optional<Sprite> result = Optional.ofNullable(spriteParser.findSprite(theGeneration, thePokemonName, true));

        if (result.isEmpty()) {
            throw new NoModelFoundException("Could not locate shiny Sprite for Pokemon - " + thePokemonName);
        }

        return result.get();
    }
}
