package com.hfish.dev.dexapi.util.webscraper.page;

import com.hfish.dev.dexapi.model.pokemon.Sprite;
import com.hfish.dev.dexapi.util.webscraper.parent.base.HtmlPageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author haydenfish
 * @version 11.30.2023
 */

@Component
public class SpriteParser extends HtmlPageParser {
    /**
     * Connects to html document and parses the data to find corresponding elements
     * Map the attributes of element containing Sprite info to a Sprite object
     *
     * @param theGeneration generation of sprite we are looking, every pokemon has a different sprite for each
     * @param thePokemonName name of the pokemon we are finding sprite for
     * @param isShiny if pokemon is shiny, find the shiny version of sprite, else the normal one
     * @return Sprite object containing corresponding fields, null if unable to locate
     */
    public Sprite findSprite(int theGeneration, String thePokemonName, boolean isShiny) {
        return parseSpriteElement(theGeneration, thePokemonName, isShiny, Sprite.resourceUrl);
    }

    private Sprite parseSpriteElement(int theGeneration, String thePokemonName, boolean isShiny, String theResourceUrl) {
        Element row = null;

        if (!isShiny) {
            row = getNormalSpriteRow(theResourceUrl, thePokemonName);
        } else {
            // TODO: select shiny row
            row = getShinySpriteRow();
        }

        return row != null ? getSpriteImage(row, theGeneration, thePokemonName) : null;
    }

    private Element getNormalSpriteRow(String theResourceUrl, String thePokemonName) {
        Document doc = connect(Sprite.resourceUrl + thePokemonName);

        // exit the method and return null if connection fails
        if (doc == null) {
            return null;
        }

        Element firstRow = doc.select("tbody").select("tr").first();

        return firstRow;
    }

    private Element getShinySpriteRow() {
        return null;
    }

    private Sprite getSpriteImage(Element theRow, int theGeneration, String thePokemonName) {
        // finds the img url attribute in given row
        ArrayList<Element> imgUrlList = theRow.select("td").select("img");

        return mapElementToModel(imgUrlList, theGeneration, thePokemonName);
    }

    private Sprite mapElementToModel(ArrayList<Element> theAttributeList, int theGeneration, String thePokemonName) {
        if (theGeneration > theAttributeList.size()) {
            return null;
        }

        // important: theGeneration - 1 to account for 0 indexing in list
        String spriteImgSrcUrl = theAttributeList.get(theGeneration - 1).attr("src");

        return new Sprite(theGeneration, thePokemonName, false, spriteImgSrcUrl);
    }
}
