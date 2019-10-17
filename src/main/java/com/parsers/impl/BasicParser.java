package com.parsers.impl;

import com.Constants;
import com.model.Product;
import com.parsers.Parser;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.IOException;
import java.util.List;

public class BasicParser implements Parser {

    private static Logger log = Logger.getLogger(BasicParser.class);

    public Product getInfoAboutProduct() {
        return null;
    }

    public Document getMainPage(String URL, String UserAgent) throws IOException {
        return Jsoup.connect(Constants.MAIN_PAGE).userAgent(Constants.USER_AGENT).referrer(Constants.REFERRER).get();
    }

    public List<String> getListOfURLProducts(Document page) {
        return null;
    }

    public Document goToProductInfo() {
        return null;
    }

    public Document nextPage(int numberOfPage, String sortBy) {
        return null;
    }
}
