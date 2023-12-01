package com.hfish.dev.dexapi.service;

import com.hfish.dev.dexapi.exception.NoModelFoundException;
import com.hfish.dev.dexapi.model.pokemon.Stats;
import com.hfish.dev.dexapi.service.stats.StatsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StatsServiceTests {
    @Autowired
    StatsService statsService;

    @Test
    public void testFindStats() {
        Stats expectedStats = new Stats(44, 48, 65, 50, 64, 43);
        Stats actualStats = statsService.findStats("Squirtle");

        assertInstanceOf(Stats.class, actualStats);

        assertEquals(expectedStats.getTotal(), actualStats.getTotal());

        assertThrows(NoModelFoundException.class, () -> statsService.findStats(""));
        assertThrows(NoModelFoundException.class, () -> statsService.findStats("abc"));
    }
}
