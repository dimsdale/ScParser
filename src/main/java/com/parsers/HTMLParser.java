package com.parsers;

import com.model.Product;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public interface HTMLParser {

    public Product getInfoAboutProduct();

    public Document getMainPage() throws IOException;

    public List<String> getListOfURLProducts(Document page);

    public Document goToProductInfo();

    public Document nextPage();

    public int getQuantityOfPages(Document document);


}
