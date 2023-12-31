package com.hfish.dev.dexapi.service.move;

import com.hfish.dev.dexapi.exception.NoModelFoundException;
import com.hfish.dev.dexapi.model.pokemon.Move;
import com.hfish.dev.dexapi.util.webscraper.parent.HtmlTableParser;
import com.hfish.dev.dexapi.util.webscraper.table.MoveParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author haydenfish
 * @version 11.29.2023
 */
@Service
public class MoveServiceImpl implements MoveService {
    private HtmlTableParser moveParser;

    @Autowired
    public MoveServiceImpl(MoveParser moveParser) {
        this.moveParser = moveParser;
    }

    /**
     * Searches for move with corresponding name, throwing NoModelFoundException if unable to locate
     * If user enters valid move name, we should always return a corresponding object
     *
     * @param theMoveName name field of the move we are searching for
     * @return Move object if found, throw exception otherwise
     */
    @Override
    public Move findMove(String theMoveName) {
        Optional<Move> result = Optional.ofNullable((Move) moveParser.findByName(theMoveName));

        if (result.isEmpty()) {
            throw new NoModelFoundException("Could not locate move with name" + theMoveName);
        }

        return result.get();
    }
}
