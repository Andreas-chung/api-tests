package com.qa.support.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

@Component
public class Util {

    private static final ObjectMapper OM = new ObjectMapper();

    static {
        OM.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public static String toJson(Object obj) {
        try {
            return OM.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Unable to serialize to JSON ");
        }
    }

    public static <T> T fromJson(String response, Class<T> valueType) {
        try {
            return OM.readValue(response, valueType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to deserialize from JSON ");
        }
    }

}