package com.hfish.dev.dexapi.util.webscraper.parent;

import com.hfish.dev.dexapi.util.webscraper.parent.base.HtmlPageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class HtmlTableParser extends HtmlPageParser {
    /**
     * Parse html table data, finding a row containing desired model, returns an object containing model fields
     *
     * @param theModelName name of the model we are looking for
     * @param theResourceUrl url to the webpage containing table of corresponding models
     * @return object if model is found in table, else null
     */
    protected Object parseModelElement(int theKeyColumn, String theModelName, String theResourceUrl) {
        theModelName = formatModelName(theModelName);

        Elements rows = selectAllTableRows(theResourceUrl);

        ArrayList<Element> attributeList = selectModelAttributes(theKeyColumn, rows, theModelName);

        return verifyModelExists(attributeList) ? mapElementToModel(attributeList) : null;
    }

    private Elements selectAllTableRows(String theResourceUrl) {
        Document doc = connect(theResourceUrl);

        Element table = doc.select("table").first();
        Elements rows = table.select("tr");

        return rows;
    }

    private ArrayList<Element> selectModelAttributes(int theKeyColumn, Elements theRows, String theModelName) {
        ArrayList<Element> attributeList = new ArrayList<>();

        for(int i = 1; i < theRows.size(); i++) {
            Element currentElement = theRows.get(i);

            if (elementContainsModel(theKeyColumn, theModelName, currentElement)) {
                attributeList = currentElement.select("td");
            }
        }

        return attributeList;
    }

    private boolean elementContainsModel(int theKeyColumn, String theModelName, Element theCurrentElement) {
        String modelNameRegex = "\\b" + theModelName + "\\b";

        Pattern p = Pattern.compile(modelNameRegex);
        Matcher m = p.matcher(theCurrentElement.text());

        if (m.find()) {
            // int '0' refers to the first table data(td) element, containing the model name
            String currentElementModelName = theCurrentElement.select("td").get(theKeyColumn).text();

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
