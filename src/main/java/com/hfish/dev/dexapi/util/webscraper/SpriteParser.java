package com.hfish.dev.dexapi.util.webscraper;

import com.hfish.dev.dexapi.model.pokemon.Sprite;
import com.hfish.dev.dexapi.util.webscraper.parent.base.HtmlParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author haydenfish
 * @version 11.30.2023
 */

@Component
public class SpriteParser extends HtmlParser {
    /**
     *
     * @param theGeneration generation of sprite we are looking, every pokemon has a different sprite for each
     * @param thePokemonName name of the pokemon we are finding sprite for
     * @param isShiny if pokemon is shiny, find the shiny version of sprite, else the normal one
     * @return Sprite object containing corresponding fields
     */
    public Sprite findSprite(int theGeneration, String thePokemonName, boolean isShiny) {
        return parseSpriteElement(theGeneration, thePokemonName, isShiny, Sprite.resourceUrl);
    }

    private Sprite parseSpriteElement(int theGeneration, String thePokemonName, boolean isShiny, String theResourceUrl) {
        Element row = null;

        if (!isShiny) {
            row = selectNormalSpriteRow(theResourceUrl, thePokemonName);
        } else {
            // TODO: select shiny row
            row = selectShinySpriteRow();
        }

        return row != null ? selectSpriteImage(row, theGeneration, thePokemonName) : null;
    }

    private Element selectNormalSpriteRow(String theResourceUrl, String thePokemonName) {
        Document doc = connect(Sprite.resourceUrl + thePokemonName);

        // exit the method and return null if connection fails
        if (doc == null) {
            return null;
        }

        Element table = doc.select("table").first();
        Element firstRow = doc.select("tbody").select("tr").first();

        return firstRow;
    }

    private Element selectShinySpriteRow() {
        return null;
    }

    private Sprite selectSpriteImage(Element theRow, int theGeneration, String thePokemonName) {
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
