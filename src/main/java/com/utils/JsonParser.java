package com.utils;

import com.model.Product;
import org.json.JSONObject;

public interface JsonParser {

     Product getInfoAboutProduct(JSONObject object);

     int getQuantityOfPages(JSONObject jsonObject);

     JSONObject getJsonObjectFromResponse(String url);



}
