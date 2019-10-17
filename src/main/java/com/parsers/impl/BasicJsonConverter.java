package com.parsers.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Product;
import com.parsers.JsonConverter;
import org.apache.log4j.Logger;

import java.io.Serializable;

public class BasicJsonConverter implements JsonConverter  {

    private static Logger logger = Logger.getLogger(BasicJsonConverter.class);
    @Override
    public String convertInJson(Product product) {
        try {
            return  new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(product);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.error("Something goes wrong in process converting Product in JSON format");
            return "Empty product";
        }

    }
}
