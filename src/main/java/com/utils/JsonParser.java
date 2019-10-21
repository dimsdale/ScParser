package com.utils;

import com.model.Product;
import org.json.JSONObject;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public interface JsonParser {

     Product getInfoAboutProduct(JSONObject object);

     int getQuantityOfPages(JSONObject jsonObject);

     JSONObject getJsonObjectFromResponse(String url);



}
