package com.utils;

import com.model.Product;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public interface HTMLParser {

    public void getInfoAboutProduct(Product product, Document document);

    public Document getMainPage() throws IOException;

    public List<String> getListOfURLProducts(Document page);

    public Document goToProductInfo(String urlProd);

    public Document nextPage(String url);

    public int getQuantityOfPages(Document document);

    public List<String> getListOfAllUrlWithProducts(int quantityOfPages, String sortBy);


}
