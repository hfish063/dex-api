package com.hfish.dev.dexapi.util.webscraper;

import com.hfish.dev.dexapi.model.pokemon.Move;
import com.hfish.dev.dexapi.util.webscraper.parent.HtmlParser;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

public class MoveParser extends HtmlParser {
    public Move findMove(String theName) {
        return null;
    }

    /**
     * @param theElements
     * @return
     */
    @Override
    protected Object mapElementToModel(ArrayList<Element> theElements) {
        return null;
    }

    /**
     * @param theElements
     * @param theItemName
     * @return
     */
    @Override
    protected boolean verifyModelExists(ArrayList<Element> theElements, String theItemName) {
        return false;
    }
}
