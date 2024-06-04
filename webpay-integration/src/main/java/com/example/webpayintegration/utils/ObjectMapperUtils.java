package com.example.webpayintegration.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T convert(Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        return mapper.convertValue(source, targetClass);
    }
    
    public static String convertObjectToJson(Object source) throws JsonProcessingException {
        if (source == null) {
            return null;
        }
        return mapper.writeValueAsString(source);
    }
}
