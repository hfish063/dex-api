package com.hfish.dev.dexapi.util.webscraper.parent;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author haydenfish
 * @version 11.28.2023
 */

public abstract class HtmlParser {
    // TODO: method documentation
    protected Object parseModelElement(String theModelName, String theResourceUrl) {
        theModelName = formatModelName(theModelName);
        ArrayList<Element> attributeList = new ArrayList<>();

        Document doc = connect(theResourceUrl);

        Element table = doc.select("table").first();
        Elements rows = table.select("tr");

        for(int i = 1; i < rows.size(); i++) {
            Element currentElement = rows.get(i);

            if (elementContainsModel(theModelName, currentElement)) {
                attributeList = currentElement.select("td");
            }
        }

        return verifyModelExists(attributeList, theModelName) ? mapElementToModel(attributeList): null;
    }

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

    protected boolean elementContainsModel(String theModelName, Element theCurrentElement) {
        Pattern p = Pattern.compile("\\b" + theModelName + "\\b");
        Matcher m = p.matcher(theCurrentElement.text());

        if (m.find()) {
            // int '0' refers to the first table data(td) element, containing the model name
            if (theCurrentElement.select("td").get(0).text().equals(theModelName)) {
                return true;
            }
        }

        return false;
    }

    protected abstract Object mapElementToModel(ArrayList<Element> theElements);

    protected abstract boolean verifyModelExists(ArrayList<Element> theElements, String theItemName);
}
