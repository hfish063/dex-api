package com.hfish.dev.dexapi.parser;

import com.hfish.dev.dexapi.model.pokemon.Stats;
import com.hfish.dev.dexapi.util.webscraper.table.StatsParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StatsParserTests {
    @Autowired
    StatsParser statsParser;

    @Test
    public void testFindStats() {
        Stats expectedStats = new Stats(45, 49, 49, 65, 65, 45);
        Stats actualStats = statsParser.findStats("Bulbasaur");

        assertInstanceOf(Stats.class, actualStats);

        assertEquals(expectedStats.getTotal(), actualStats.getTotal());

        assertNull(statsParser.findStats(""));
    }
}
