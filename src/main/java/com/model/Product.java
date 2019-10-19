package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {

    private long article_id;

    private String productName;

    private String brand;

    private List<String> colorsOfProduct;

    private double price;

    public long getArticle_id() {
        return article_id;
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

    public double getPrice() {
        return price;
    }

    public void setArticle_id(long article_id) {
        this.article_id = article_id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColorsOfProduct(List<String> colorsOfProduct) {
        this.colorsOfProduct = colorsOfProduct;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product() {
    }
}
