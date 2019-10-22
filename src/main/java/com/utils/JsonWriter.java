package com.utils;

import com.model.Product;

import java.io.IOException;
import java.util.List;

public interface JsonWriter {

    public void writeInFile(List<Product> product, String path) throws IOException;
}
