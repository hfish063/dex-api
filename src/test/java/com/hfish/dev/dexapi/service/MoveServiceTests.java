package com.hfish.dev.dexapi.service;

import com.hfish.dev.dexapi.exception.NoModelFoundException;
import com.hfish.dev.dexapi.model.enums.Type;
import com.hfish.dev.dexapi.model.pokemon.Move;
import com.hfish.dev.dexapi.service.move.MoveService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MoveServiceTests {
    @Autowired
    MoveService moveService;

    @Test
    public void testFindMove() {
        Move expectedMove = new Move(1, "Acid", Type.POISON, "May lower opponent's Special Defense.");
        Move actualMove = moveService.findMove("Acid");

        assertInstanceOf(Move.class, actualMove);

        assertEquals(expectedMove.getName(), actualMove.getName());
        assertEquals(expectedMove.getType(), actualMove.getType());
        assertEquals(expectedMove.getEffect(), actualMove.getEffect());

        assertThrows(NoModelFoundException.class, () -> moveService.findMove(""));
        assertThrows(NoModelFoundException.class, () -> moveService.findMove("xyz"));
    }
}
