package com.parsers.impl;

import com.Constants;
import com.Counters;
import com.model.Product;
import com.parsers.HTMLParser;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.IOException;
import java.util.List;

public class BasicHTMLParser implements HTMLParser {

    private static Logger log = Logger.getLogger(BasicHTMLParser.class);

    public Product getInfoAboutProduct() {
        return null;
    }

    public Document getMainPage() throws IOException {
        return Jsoup.connect(Constants.MAIN_PAGE).userAgent(Constants.USER_AGENT).referrer(Constants.REFERRER).get();
    }

    public List<String> getListOfURLProducts(Document page) {
        return null;
    }

    public Document goToProductInfo() {
        return null;
    }

    public Document nextPage() {
        try {
            return Jsoup.connect(getURLNextPage(Counters.CURRENT_PAGE_OF_LIST, Constants.SORT_BY_TOPSELLER)).userAgent(Constants.USER_AGENT).get();
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }

    }

    public int getQuantityOfPages(Document document) {
        try {
            return Integer.parseInt(document.select("li[class=_pageNumbers_557b1]").last().text());
        } catch (Exception ex){
            log.error("Something goes wrong in the searching of quantity of pages. Wrong css Query");
        }
        return -1;
       }

    private String getURLNextPage(int numberOfPage, String sortBy){
        return String.format(Constants.TEMPLATE_OF_NEW_PAGES_WITH_PRODUCTS, numberOfPage, sortBy);
    }
}
