package com;

import com.model.Product;
import com.parsers.impl.BasicJsonConverter;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Logger logMain = Logger.getLogger(Main.class);
     public static void main(String[] args) throws IOException {
         BasicJsonConverter converter = new BasicJsonConverter();
        List<String> sss= new ArrayList<>();
        sss.add("Treol");
        sss.add("gagaga");
        Product product = new Product();
        product.setArticle_id(1);
        product.setProductName("blanla");
        product.setColorsOfProduct(sss);
        product.setBrand("dhgdhgd");
        product.setPrice(0.2);
        System.out.println(converter.convertInJson(product));
    }
}
