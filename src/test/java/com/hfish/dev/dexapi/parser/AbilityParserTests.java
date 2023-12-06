package com.hfish.dev.dexapi.parser;

import com.hfish.dev.dexapi.model.pokemon.Ability;
import com.hfish.dev.dexapi.util.webscraper.table.AbilityParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AbilityParserTests {
    @Autowired
    AbilityParser abilityParser;

    @Test
    public void testFindByName() {
        Ability expectedAbility = new Ability("Armor Tail", "Prevents opponent using priority moves.");
        Ability actualAbility = abilityParser.findByName("Armor Tail");

        assertInstanceOf(Ability.class, actualAbility);

        assertEquals(expectedAbility.getName(), actualAbility.getName());
        assertEquals(expectedAbility.getEffect(), actualAbility.getEffect());

        assertNull(abilityParser.findByName(""));
    }
}
