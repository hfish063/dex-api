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
     * Find the non-shiny version of pokemon sprite from given generation, throws NoModelFoundException if unable to locate
     * Should always return a corresponding object if input data is valid
     *
     * @param theGeneration generation of pokemon sprite to find, each generation has various different sprites
     * @param thePokemonName name of the pokemon to find sprite for
     * @return Sprite object with matching fields
     */
    @Override
    public Sprite findNormalSprite(int theGeneration, String thePokemonName) {
        Optional<Sprite> result = Optional.ofNullable(spriteParser.findSprite(theGeneration, thePokemonName, false));

        if (result.isEmpty()) {
            throw new NoModelFoundException("Could not locate Sprite for Pokemon/Generation - " + thePokemonName + "/" + theGeneration);
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
            throw new NoModelFoundException("Could not locate shiny Sprite for Pokemon/Generation - " + thePokemonName + "/" + theGeneration);
        }

        return result.get();
    }
}
