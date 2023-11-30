package com.hfish.dev.dexapi;

import com.hfish.dev.dexapi.exception.NoModelFoundException;
import com.hfish.dev.dexapi.model.pokemon.Sprite;
import com.hfish.dev.dexapi.util.webscraper.SpriteParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SpriteParserTests {
    @Autowired
    private SpriteParser spriteParser;

    @Test
    public void testFindSprite() {
        Sprite expectedSprite = new Sprite(1, "Bulbasaur", false, "https://img.pokemondb.net/sprites/red-blue/normal/bulbasaur.png");
        Sprite actualSprite = spriteParser.findSprite(1, "Bulbasaur", false);

        assertInstanceOf(Sprite.class, actualSprite);

        assertEquals(expectedSprite.getGeneration(), actualSprite.getGeneration());
        assertEquals(expectedSprite.getImgSrcUrl(), actualSprite.getImgSrcUrl());
        assertEquals(expectedSprite.getImgSrcUrl(), actualSprite.getImgSrcUrl());

        assertNull(spriteParser.findSprite(1, "xyz", false));
    }

    @Test
    public void testFindShinySprite() {

    }
}
