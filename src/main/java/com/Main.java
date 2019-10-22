package com;

import com.model.Product;
import com.utils.JsonWriter;
import com.utils.impl.BasicJsonWriter;
import com.utils.impl.BasicJsonParser;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static BasicJsonParser jsonParser;
    private static JsonWriter jsonWriter;
    private volatile static List<Product> products = new ArrayList<>();
    private volatile static JSONArray workingJsonArray;
    private static JSONObject tempSingleJson;
    private static JSONObject jsonWithServerResponse;
    private static String pathForCreatingFile;
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.print("Welcome! Please insert the path, where will create file with JSON: ");
         pathForCreatingFile = scanner.next();
         scanner.close();
         jsonParser = new BasicJsonParser();
         jsonWriter = new BasicJsonWriter();
         Constants.QUANTITY_OF_PAGES = jsonParser.getQuantityOfPages(jsonParser.getJsonObjectFromResponse(String.format(Constants.TEMPLATE_OF_REQUEST_TO_SERVER, 1)));
         if (Constants.QUANTITY_OF_PAGES == -1)
             System.exit(-1);
         for (int i = 1; i <=1; i++)
         {
             jsonWithServerResponse = jsonParser.getJsonObjectFromResponse(String.format(Constants.TEMPLATE_OF_REQUEST_TO_SERVER, i));
             workingJsonArray = jsonWithServerResponse.getJSONArray("entities");
                for (int k = 0; k < workingJsonArray.length(); k++){
                    tempSingleJson = workingJsonArray.getJSONObject(k);
                    products.add(jsonParser.getInfoAboutProduct(tempSingleJson));
                }

          }
         try {
             jsonWriter.writeInFile(products, pathForCreatingFile);
         } catch (IOException e){
             e.printStackTrace();
         }

     }
}
