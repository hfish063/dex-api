package com.hfish.dev.dexapi.service.ability;

import com.hfish.dev.dexapi.model.pokemon.Ability;

/**
 * @author haydenfish
 * @version 12.05.2023
 */

public interface AbilityService {
    public Ability findAbility(String theAbilityName);
}
