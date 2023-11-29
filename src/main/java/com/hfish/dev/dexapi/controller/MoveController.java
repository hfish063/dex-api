package com.hfish.dev.dexapi.controller;

import com.hfish.dev.dexapi.model.pokemon.Move;
import com.hfish.dev.dexapi.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haydenfish
 * @version 11.29.2023
 */

@RestController
@RequestMapping("/api")
public class MoveController {
    private MoveService moveService;

    @Autowired
    public MoveController(MoveService moveService) {
        this.moveService = moveService;
    }

    @GetMapping("/move/{theMoveName}")
    public Move findMove(@PathVariable("theMoveName") String theMoveName) {
        return moveService.findMove(theMoveName);
    }
}
