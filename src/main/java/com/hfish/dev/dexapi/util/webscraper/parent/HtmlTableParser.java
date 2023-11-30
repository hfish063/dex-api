package com.hfish.dev.dexapi.util.webscraper.parent;

import com.hfish.dev.dexapi.util.webscraper.parent.base.HtmlParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class HtmlTableParser extends HtmlParser {
    /**
     * Parse html table data, finding a row containing desired model, returns an object containing model fields
     *
     * @param theModelName name of the model we are looking for
     * @param theResourceUrl url to the webpage containing table of corresponding models
     * @return object if model is found in table, else null
     */
    protected Object parseModelElement(String theModelName, String theResourceUrl) {
        theModelName = formatModelName(theModelName);

        Elements rows = selectAllTableRows(theResourceUrl);

        ArrayList<Element> attributeList = selectModelAttributes(rows, theModelName);

        return verifyModelExists(attributeList) ? mapElementToModel(attributeList) : null;
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

    private Elements selectAllTableRows(String theResourceUrl) {
        Document doc = connect(theResourceUrl);

        Element table = doc.select("table").first();
        Elements rows = table.select("tr");

        return rows;
    }

    private ArrayList<Element> selectModelAttributes(Elements theRows, String theModelName) {
        ArrayList<Element> attributeList = new ArrayList<>();

        for(int i = 1; i < theRows.size(); i++) {
            Element currentElement = theRows.get(i);

            if (elementContainsModel(theModelName, currentElement)) {
                attributeList = currentElement.select("td");
            }
        }

        return attributeList;
    }

    private boolean elementContainsModel(String theModelName, Element theCurrentElement) {
        String modelNameRegex = "\\b" + theModelName + "\\b";

        Pattern p = Pattern.compile(modelNameRegex);
        Matcher m = p.matcher(theCurrentElement.text());

        if (m.find()) {
            // int '0' refers to the first table data(td) element, containing the model name
            String currentElementModelName = theCurrentElement.select("td").get(0).text();

            if (currentElementModelName.equals(theModelName)) {
                return true;
            }
        }

        return false;
    }

    private boolean verifyModelExists(ArrayList<Element> theAttributeList) {
        return !theAttributeList.isEmpty();
    }

    /**
     * Provides implementation for taking list of attributes, and passing them to model constructor to create a new
     * object
     * Defined in class, as model fields are not universal
     *
     * @param theAttributeList list of attributes to element containing our required model fields
     * @return instance of model being searched for
     */
    protected abstract Object mapElementToModel(ArrayList<Element> theAttributeList);
}