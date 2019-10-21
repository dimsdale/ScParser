package com.utils.impl;

import com.Constants;
import com.Counters;
import com.model.Product;
import com.utils.JsonParser;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BasicJsonParser implements JsonParser {

    private JSONArray workingJsonArray;
    private static Logger log = Logger.getLogger(BasicJsonParser.class);

    public void getInfoAboutProduct(Product product, Document document) {

    }

    public Document connectToTheSite() throws IOException {
        log.debug("Connecting to the site");
        Counters.COUNTER_HTTP_REQUESTS++;
        return Jsoup.connect(Constants.MAIN_PAGE).userAgent(Constants.USER_AGENT).referrer(Constants.REFERRER).get();
    }

    public List<String> getListOfURLProducts(String url, List<String> futureListWithUrl) {
        int idProduct;
        String brandProduct;
        String nameProduct;
        try {
            workingJsonArray = getJsonArrayFromUrl(url);
            for (int i = 0; i < workingJsonArray.length(); i++){
                idProduct = workingJsonArray.getJSONObject(i).getInt("id");
                brandProduct = workingJsonArray.getJSONObject(i).getJSONObject("attributes").getJSONObject("brand").getJSONObject("values").getString("value");
                nameProduct = workingJsonArray.getJSONObject(i).getJSONObject("attributes").getJSONObject("name").getJSONObject("values").getString("label").replaceFirst("\\s","-").replaceAll("\\'", "");
                futureListWithUrl.add(String.format(Constants.TEMPLATE_OF_PAGE_WITH_PRODUCT_INFO, brandProduct, nameProduct, idProduct));
            }
        } catch (IOException e) {
            log.error("Something goes wrong in reading JSON. Bad Request");
            System.exit(-1);
        }

        return futureListWithUrl;
    }

    public Document goToProductInfo(String urlProd) {
        return null;
    }

    public int getQuantityOfPages(Document document) {
        try {
            return Integer.parseInt(document.select("li[class=_pageNumbers_557b1]").last().text());
        } catch (Exception ex){
            log.error("Something goes wrong in the searching of quantity of pages. Wrong css Query");
            return -1;
        }
       }

    public List<String> getListOfRequestslWithProducts(int quantityOfPages){
        log.info("Create list with all urls with products");
        List<String> allUrl = new ArrayList<>();
        for (int i = 1; i <= quantityOfPages; i++)
            allUrl.add(String.format(Constants.TEMPLATE_OF_REQUEST_TO_SERVER, quantityOfPages));
        return allUrl;

    }

    private String readJsonFromUrl(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = reader.read()) != -1) {
            sb.append((char) cp);
        }
        Counters.COUNTER_HTTP_REQUESTS++;
        return sb.toString();
    }

    private JSONArray getJsonArrayFromUrl(String url) throws IOException {
        InputStream stream = new URL(url).openStream();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String jsonText = readJsonFromUrl(reader);
            JSONObject json = new JSONObject(jsonText);
            return json.getJSONArray("entities");
        } finally {
            Counters.COUNTER_HTTP_REQUESTS++;
            stream.close();
        }
    }
}
