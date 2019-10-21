package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Product;
import com.utils.JsonParser;
import com.utils.JsonWriter;
import com.utils.impl.BasicJsonParser;
import com.utils.impl.BasicJsonConverter;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Logger logMain = Logger.getLogger(Main.class);
    private static BasicJsonParser jsonParser;
    private static JsonWriter jsonWriter;
    private static List<String> futureListWithUrl = new ArrayList<>(100);
    private static List<String> allPagesWithProducts;
     public static void main(String[] args) throws IOException {
         jsonParser = new BasicJsonParser();
         jsonWriter = new BasicJsonConverter();
         futureListWithUrl = jsonParser.getListOfURLProducts(String.format(Constants.TEMPLATE_OF_REQUEST_TO_SERVER, 1), futureListWithUrl);
//         JSONObject object = jsonParser.getJsonFromUrl(String.format(Constants.TEMPLATE_OF_REQUEST_TO_SERVER, 1));
//         JSONArray array = object.getJSONArray("entities");
//         String q = array.getJSONObject(0).getJSONObject("attributes").getJSONObject("brand").getJSONObject("values").getString("value");
//         System.out.println(q);
//         for (int i = 0; i < array.length(); i++){
//
//         }
//         System.out.println(Jsoup.connect(String.format(Constants.TEMPLATE_OF_REQUEST_TO_SERVER,1)).userAgent(Constants.USER_AGENT).get());
//         Constants.QUANTITY_OF_PAGES = jsonParser.getQuantityOfPages(jsonParser.connectToTheSite());
//         if (Constants.QUANTITY_OF_PAGES == -1){
//             System.exit(Constants.QUANTITY_OF_PAGES);
//         }
//         allPagesWithProducts = jsonParser.getListOfRequestslWithProducts(Constants.QUANTITY_OF_PAGES);
//         for (String currentPage: allPagesWithProducts){
//             allProductsList = jsonParser.getListOfURLProducts(currentPage);
//         }



     }
}
