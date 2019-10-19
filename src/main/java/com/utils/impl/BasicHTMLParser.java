package com.utils.impl;

import com.Constants;
import com.Counters;
import com.model.Product;
import com.utils.HTMLParser;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasicHTMLParser implements HTMLParser {

    private static Logger log = Logger.getLogger(BasicHTMLParser.class);

    public void getInfoAboutProduct(Product product, Document document) {

    }

    public Document getMainPage() throws IOException {
        return Jsoup.connect(Constants.MAIN_PAGE).userAgent("Mozilla").get();
    }

    public List<String> getListOfURLProducts(Document page) {
        return null;
    }

    public Document goToProductInfo(String urlProd) {
        return null;
    }

    public Document nextPage(String url) {
        try {
            return Jsoup.connect(url).userAgent(Constants.USER_AGENT).get();
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

    public List<String> getListOfAllUrlWithProducts(int quantityOfPages, String sortBy){
        log.info("Create list with all url with products");
        List<String> allUrl = new ArrayList<>();
        for (int i = 2; i <= quantityOfPages; i++){
            allUrl.add(String.format(Constants.TEMPLATE_OF_NEW_PAGES_WITH_PRODUCTS, 2, sortBy));
        }
        return allUrl;
    }
}
