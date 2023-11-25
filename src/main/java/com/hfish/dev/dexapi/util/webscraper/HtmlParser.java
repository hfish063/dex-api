package com.hfish.dev.dexapi.util.webscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author haydenfish
 * @version 11.24.2023
 */

public abstract class HtmlParser {
    public Document connect(String theResourceUrl) {
        Document doc = null;

        try {
            doc = Jsoup.connect(theResourceUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc;
    }
}
