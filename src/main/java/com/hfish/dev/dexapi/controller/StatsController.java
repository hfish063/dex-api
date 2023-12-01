package com.hfish.dev.dexapi.controller;

import com.hfish.dev.dexapi.model.pokemon.Stats;
import com.hfish.dev.dexapi.service.stats.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haydenfish
 * @version 11.30.2023
 */

@RestController
@RequestMapping("/api")
public class StatsController {
    StatsService statsService;

    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @RequestMapping("/stats/{thePokemonName}")
    public Stats findStats(@PathVariable("thePokemonName") String thePokemonName) {
        return statsService.findStats(thePokemonName);
    }
}
