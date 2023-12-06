package com.hfish.dev.dexapi.service.ability;

import com.hfish.dev.dexapi.exception.NoModelFoundException;
import com.hfish.dev.dexapi.model.pokemon.Ability;
import com.hfish.dev.dexapi.util.webscraper.parent.HtmlTableParser;
import com.hfish.dev.dexapi.util.webscraper.table.AbilityParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author haydenfish
 * @version 12.05.2023
 */

@Service
public class AbilityServiceImpl implements AbilityService {
    private HtmlTableParser abilityParser;

    @Autowired
    public AbilityServiceImpl(AbilityParser abilityParser) {
        this.abilityParser = abilityParser;
    }

    /**
     * Searches for ability with corresponding name, throwing NoModelFoundException if unable to locate
     * If user enters valid ability name, we should always return a corresponding object
     *
     * @param theAbilityName name of the ability to search for
     * @return Ability object if found, throw exception otherwise
     */
    @Override
    public Ability findAbility(String theAbilityName) {
        Optional<Ability> result = Optional.ofNullable((Ability) abilityParser.findByName(theAbilityName));

        if (result.isEmpty()) {
            throw new NoModelFoundException("Could not locate ability with name - " + theAbilityName);
        }

        return result.get();
    }
}
