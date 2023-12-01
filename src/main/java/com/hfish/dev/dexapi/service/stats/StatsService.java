package com.hfish.dev.dexapi.service.stats;

import com.hfish.dev.dexapi.model.pokemon.Stats;

public interface StatsService {
    public Stats findStats(String thePokemonName);
}
