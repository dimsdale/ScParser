package com;

import com.model.Product;
import com.utils.JsonParser;
import com.utils.JsonWriter;
import com.utils.impl.BasicJsonWriter;
import com.utils.impl.BasicJsonParser;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static JsonWriter jsonWriter;
    private static JsonParser jsonParser;
    private static List<Product> products = new ArrayList<>();
    private static JSONObject jsonWithServerResponse;
    private static JSONArray workingJsonArray;
    private static Logger logger = Logger.getLogger(Main.class);

     public static void main(String[] args)  {
         File file = new File("Product.json");
         jsonWriter = new BasicJsonWriter();
         jsonParser = new BasicJsonParser();
         Constants.QUANTITY_OF_PAGES = jsonParser.getQuantityOfPages(jsonParser.getJsonObjectFromResponse(String.format(Constants.TEMPLATE_OF_REQUEST_TO_SERVER, 1)));
         if (Constants.QUANTITY_OF_PAGES == -1)
             System.exit(-1);
         logger.info("Parsing...");
         for (int i = 1; i <= Constants.QUANTITY_OF_PAGES; i++)
         {
             jsonWithServerResponse = jsonParser.getJsonObjectFromResponse(String.format(Constants.TEMPLATE_OF_REQUEST_TO_SERVER, i));
             workingJsonArray = jsonWithServerResponse.getJSONArray("entities");
             for (int k = 0; k < workingJsonArray.length(); k++){
                 products.add(jsonParser.getInfoAboutProduct(workingJsonArray.getJSONObject(k)));
             }
         }

         jsonWriter.writeInFile(products, file);
         logger.info("Writing in file finished");
         System.out.println("Quantity of HTTP Requests: " + Counters.COUNTER_HTTP_REQUESTS );
         System.out.println("Quantity of Products: " + Counters.COUNTER_OF_PRODUCTS);
     }
}
