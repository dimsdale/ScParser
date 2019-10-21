package com;

import com.model.Product;
import com.utils.JsonWriter;
import com.utils.impl.BasicJsonConverter;
import com.utils.impl.BasicJsonParser;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Logger logMain = Logger.getLogger(Main.class);
    private static BasicJsonParser jsonParser;
    private static JsonWriter jsonWriter;
    private volatile static List<Product> products = new ArrayList<>();
    private volatile static JSONArray workingJsonArray;
    private static JSONObject tempJson;
     public static void main(String[] args) {
         jsonParser = new BasicJsonParser();
         jsonWriter = new BasicJsonConverter();
         JSONObject object = jsonParser.getJsonObjectFromResponse(String.format(Constants.TEMPLATE_OF_REQUEST_TO_SERVER, 1));
         Constants.QUANTITY_OF_PAGES = jsonParser.getQuantityOfPages(object);
         System.out.println("Sum pages" + Constants.QUANTITY_OF_PAGES);
         if (Constants.QUANTITY_OF_PAGES == -1)
             System.exit(-1);
         for (int i = 1; i <= Constants.QUANTITY_OF_PAGES; ++i)
         {
             System.out.println("Current page " + i);
                workingJsonArray = object.getJSONArray("entities");
                for (int k = 0; k < workingJsonArray.length(); k++){
                    tempJson = workingJsonArray.getJSONObject(k);
                    System.out.println(tempJson.toString());
                    products.add(jsonParser.getInfoAboutProduct(tempJson));
                    System.out.println("Current page" + i);
                }
                if (i == Constants.QUANTITY_OF_PAGES)
                    break;
             System.out.println("Currentpage" + i);
                object = jsonParser.getJsonObjectFromResponse(String.format(Constants.TEMPLATE_OF_REQUEST_TO_SERVER, i));
         }





     }
}
