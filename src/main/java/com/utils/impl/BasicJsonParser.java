package com.utils.impl;

import com.Counters;
import com.model.Product;
import com.utils.JsonParser;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.*;
import java.net.URL;

public class BasicJsonParser implements JsonParser {

    private static Logger log = Logger.getLogger(BasicJsonParser.class);

    public Product getInfoAboutProduct(JSONObject object) {
        Product product = new Product();
        try {
            product.setId(object.getInt("id"));
            product.setBrand(object.getJSONObject("attributes").getJSONObject("brand").getJSONObject("values").getString("label"));
            product.setProductName(object.getJSONObject("attributes").getJSONObject("name").getJSONObject("values").getString("label"));
            product.setPrice(object.getJSONObject("priceRange").getJSONObject("min").getInt("withTax"));
            product.setColorsOfProduct(object);
            product.setSizes(object);
            Counters.COUNTER_OF_PRODUCTS++;
            return product;
        }catch (JSONException e){
            log.error("Error. Was empty JSON");
        } catch (NullPointerException e){
            product.setId(-1);
            return product;
        }
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

    private String readJsonFromUrl(Reader reader) {
        StringBuilder sb = new StringBuilder();
        int cp;
        try {
            while ((cp = reader.read()) != -1) {
                sb.append((char) cp);
            }
        } catch (IOException e){
            log.error("Cannot read response Json: ");
            e.printStackTrace();
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
              return new JSONObject(jsonText);

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
