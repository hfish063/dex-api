package com.hfish.dev.dexapi.util.webscraper.parent.base;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author haydenfish
 * @version 11.30.2023
 */
public class HtmlPageParser {
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

    /**
     * Formats the name attribute of model
     * Capitalizes first letter of each word in String, ensuring it corresponds to the format of html document
     *
     * @param theModelName name of the object name we are formatting
     * @return String consisting of word(s) with capitalized first letter
     */
    protected String formatModelName(String theModelName) {
        final int CHAR_LIMIT = 100;
        int length = theModelName.length();

        StringBuilder result = new StringBuilder();

        // toLowerCase is important, removes possibility of random characters being capitalized
        theModelName = theModelName.toLowerCase();

        for(int i = 0; i < length && length < CHAR_LIMIT; i++) {
            char currentChar = theModelName.charAt(i);

            if (i > 0 && theModelName.charAt(i - 1) == ' ') {
                result.append(Character.toUpperCase(currentChar));
            } else if (i == 0) {
                result.append(Character.toUpperCase(currentChar));
            } else {
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}
