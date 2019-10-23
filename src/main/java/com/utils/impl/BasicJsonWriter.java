package com.utils.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Product;
import com.utils.JsonWriter;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BasicJsonWriter implements JsonWriter {

    private static Logger logger = Logger.getLogger(BasicJsonWriter.class);

    public void writeInFile(List<Product> products, File file)  {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(file));

        }catch (IOException e){
            logger.error("Cannot open File Writer");
            e.printStackTrace();
            return;
        }
        try {
            writer.write(products.toString());
        }  catch (IOException e){
            logger.error("Cannot write in the FIle");
        } catch (NullPointerException e){
            logger.error("Products are not initialized");
        }
        finally
        {
            try {
                writer.close();
            } catch (IOException e){
                logger.error("Cannot close BufferedWriter");
                e.printStackTrace();
            }
        }

    }
}
