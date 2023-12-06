package com.hfish.dev.dexapi.controller;

import com.hfish.dev.dexapi.model.pokemon.Pokemon;
import com.hfish.dev.dexapi.service.pokemon.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haydenfish
 * @version 11.24.2023
 */

@RestController
@RequestMapping("/api")
public class PokemonController {
    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon/{thePokemonName}")
    public Pokemon findPokemon(@PathVariable("thePokemonName") String thePokemonName) {
        return pokemonService.findPokemon(thePokemonName);
    }
}
