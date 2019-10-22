package com.utils.impl;

import com.Counters;
import com.model.Product;
import com.utils.JsonParser;
import org.apache.log4j.Logger;
import org.json.JSONObject;


import java.io.*;
import java.net.URL;

public class BasicJsonParser implements JsonParser {

    private static Logger log = Logger.getLogger(BasicJsonParser.class);

    public Product getInfoAboutProduct(JSONObject object) {
        Product product = new Product();
        product.setId(object.getInt("id"));
        System.out.println("Id id " + product.getId());
        product.setBrand(object.getJSONObject("attributes").getJSONObject("brand").getJSONObject("values").getString("label"));
        System.out.println("Brand is " + product.getBrand());
        product.setProductName(object.getJSONObject("attributes").getJSONObject("name").getJSONObject("values").getString("label"));
        System.out.println("Product name is " + product.getProductName());
        product.setPrice(object.getJSONObject("priceRange").getJSONObject("min").getInt("withTax"));
        product.setColorsOfProduct(object);
        product.setSizes(object);
        Counters.COUNTER_OF_PRODUCTS++;
        System.out.println(Counters.COUNTER_OF_PRODUCTS);
        return product;
    }

    public int getQuantityOfPages(JSONObject jsonObject) {
        try {
            log.info("Getting all pages...");
            return jsonObject.getJSONObject("pagination").getInt("last");
        } catch (Exception e){
            log.error("Something goes wrong. Bad Request or JSON response");
            e.printStackTrace();
        }
        return -1;
    }

    private String readJsonFromUrl(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = reader.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject getJsonObjectFromResponse(String url) {
        InputStream stream = null;
        BufferedReader reader;
        String jsonText;
        try {
            stream = new URL(url).openStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            jsonText = readJsonFromUrl(reader);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } catch (IOException e) {
            log.error("Has problems with reading. More information below");
            e.printStackTrace();
        } catch (NullPointerException e){
            log.error("Empty Url Response");
            e.printStackTrace();
        }
        finally {
            Counters.COUNTER_HTTP_REQUESTS++;
            try {
                stream.close();
            } catch (IOException e) {
                log.error("Cannot close input stream");
                e.printStackTrace();
            }
        }
        return null;
    }
}
