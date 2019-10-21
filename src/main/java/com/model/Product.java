package com.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product extends JSONObject implements Serializable {

    private long id;

    private String productName;

    private String brand;

    private List<String> colorsOfProduct;

    private List<String> sizes;

    private int price;

    public long getId() {
        return id;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(JSONObject jsonWithSizes) {
       JSONArray temp = jsonWithSizes.getJSONArray("variants");
       sizes = new ArrayList<>(temp.length());
       for (int i = 0; i < temp.length(); i++){
           System.out.println(temp.getJSONObject(i).getJSONObject("attributes").toString());
           sizes.add(temp.getJSONObject(i).getJSONObject("attributes").getJSONObject("vendorSize").getJSONObject("values").getString("label"));
       }
    }

    public String getProductName() {
        return productName;
    }

    public String getBrand() {
        return brand;
    }

    public List<String> getColorsOfProduct() {
        return colorsOfProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColorsOfProduct(JSONObject jsonWithColors) {
        JSONArray temp;
        try {
            temp = jsonWithColors.getJSONObject("attributes").getJSONObject("colorDetail").getJSONArray("values");
        } catch (JSONException e){
            return;
        }

        colorsOfProduct = new ArrayList<>(temp.length());
        for (int i = 0; i < temp.length(); i++)
            colorsOfProduct.add(temp.getJSONObject(i).getString("label"));
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product() {
    }
}
