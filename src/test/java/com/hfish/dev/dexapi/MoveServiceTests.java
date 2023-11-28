package com.hfish.dev.dexapi;

import com.hfish.dev.dexapi.model.enums.Type;
import com.hfish.dev.dexapi.model.pokemon.Move;
import com.hfish.dev.dexapi.service.MoveService;
import com.hfish.dev.dexapi.util.webscraper.MoveParser;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MoveServiceTests {
    @Autowired
    MoveService moveService;

    @Mock
    MoveParser moveParser;

    @Test
    public void testFindMove() {
        Move expectedMove = new Move(1, "Acid", Type.POISON, "May lower opponent's Special Defense.");
        Move actualMove = moveService.findMove("Acid");

        assertEquals(expectedMove, actualMove);

        assertNull(moveService.findMove(" "));
        assertNull(moveService.findMove("xyz"));
    }
}
