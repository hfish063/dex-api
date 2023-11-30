package com.hfish.dev.dexapi.controller;

import com.hfish.dev.dexapi.model.pokemon.Sprite;
import com.hfish.dev.dexapi.service.SpriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haydenfish
 * @version 11.30.2023
 */

@RestController
@RequestMapping("/api")
public class SpriteController {
    private SpriteService spriteService;

    @Autowired
    public SpriteController(SpriteService spriteService) {
        this.spriteService = spriteService;
    }

    @GetMapping("/sprite/{thePokemonName}/{theGeneration}")
    public Sprite findNormalSprite(@PathVariable("thePokemonName") String thePokemonName, @PathVariable("theGeneration") int theGeneration) {
        return spriteService.findNormalSprite(theGeneration, thePokemonName);
    }
}
