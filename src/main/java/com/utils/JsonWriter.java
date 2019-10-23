package com.utils;

import com.model.Product;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface JsonWriter {

    void writeInFile(List<Product> product, File file);
}
