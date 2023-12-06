package com.hfish.dev.dexapi.controller;

import com.hfish.dev.dexapi.model.pokemon.Ability;
import com.hfish.dev.dexapi.service.ability.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haydenfish
 * @version 12.05.2023
 */

@RestController
@RequestMapping("/api")
public class AbilityController {
    private AbilityService abilityService;

    @Autowired
    public AbilityController(AbilityService abilityService) {
        this.abilityService = abilityService;
    }

    @GetMapping("/ability/{theAbilityName}")
    public Ability findAbility(@PathVariable("theAbilityName") String theAbilityName) {
        return abilityService.findAbility(theAbilityName);
    }
}
