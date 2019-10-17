package com.parsers;

import com.model.Product;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public interface Parser {

    public Product getInfoAboutProduct();

    public Document getMainPage(String URL, String UserAgent) throws IOException;

    public List<String> getListOfURLProducts(Document page);

    public Document goToProductInfo();

    public Document nextPage(int numberOfPage, String sortBy);


}
