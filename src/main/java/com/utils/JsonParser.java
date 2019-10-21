package com.utils;

import com.model.Product;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public interface JsonParser {

    public void getInfoAboutProduct(Product product, Document document);

    public Document connectToTheSite() throws IOException;

    public List<String> getListOfURLProducts(String url, List<String> futureListWithUrl);

    public Document goToProductInfo(String urlProd);

    public int getQuantityOfPages(Document document);

    public List<String> getListOfRequestslWithProducts(int quantityOfPages);


}
