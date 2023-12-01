package com.hfish.dev.dexapi.service.stats;

import com.hfish.dev.dexapi.exception.NoModelFoundException;
import com.hfish.dev.dexapi.model.pokemon.Stats;
import com.hfish.dev.dexapi.util.webscraper.table.StatsParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatsServiceImpl implements StatsService {
    StatsParser statsParser;

    @Autowired
    public StatsServiceImpl(StatsParser statsParser) {
        this.statsParser = statsParser;
    }

    /**
     * Finds the corresponding stats for given pokemon name, throw NoModelFoundException if stats do not exist
     * for the given name
     *
     * @param thePokemonName name of the pokemon we wish to find stats for
     * @return Stats object containing all the data we parsed from html table
     */
    @Override
    public Stats findStats(String thePokemonName) {
        Optional<Stats> result = Optional.ofNullable(statsParser.findStats(thePokemonName));

        if (result.isEmpty()) {
            throw new NoModelFoundException("Could not locate stats for pokemon - " + thePokemonName);
        }

        return result.get();
    }
}
