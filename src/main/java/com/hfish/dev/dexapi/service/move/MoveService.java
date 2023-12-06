package com.hfish.dev.dexapi.service.move;

import com.hfish.dev.dexapi.model.pokemon.Move;

/**
 * @author haydenfish
 * @version 12.06.2023
 */

public interface MoveService {
    public Move findMove(String theName);
}
