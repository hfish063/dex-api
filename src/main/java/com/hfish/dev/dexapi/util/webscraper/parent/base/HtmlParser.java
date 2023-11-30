package com.hfish.dev.dexapi.util.webscraper.parent.base;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author haydenfish
 * @version 11.30.2023
 */
public class HtmlParser {
    /**
     * Connect to html document with Jsoup library, returns the html Document
     * Throws IOException if connection fails
     *
     * @param theResourceUrl url of the site for Jsoup to establish connection to
     * @return Jsoup Document object with site's html data
     */
    protected Document connect(String theResourceUrl) {
        Document doc = null;

        try {
            doc = Jsoup.connect(theResourceUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc;
    }
}
