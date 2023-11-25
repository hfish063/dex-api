package com.hfish.dev.dexapi.model.enums;

/**
 * @author haydenfish
 * @version 11.24.2023
 */

public enum Category {
    BATTLE_ITEMS("BATTLE ITEMS"),
    BERRIES("BERRIES"),
    GENERAL_ITEMS("GENERAL ITEMS"),
    HOLD_ITEMS("HOLD ITEMS"),
    MACHINES("MACHINES"),
    MEDICINE("MEDICINE"),
    POKEBALLS("POKEBALLS"),
    UNKNOWN("UNKNOWN");

    public final String label;

    Category(String label) {
        this.label = label;
    }

    /**
     * Find the category given a label String, return UNKNOWN if category is not found
     *
     * @param theLabel label String to search Category enum for
     * @return Category value, UNKNOWN if not found
     */
    public static Category valueOfLabel(String theLabel) {
        for(Category c : values()) {
            if (c.label.equalsIgnoreCase(theLabel)) {
                return c;
            }
        }
        return UNKNOWN;
    }
}
