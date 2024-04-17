package com.example.webpayintegration.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {

    public static <T> T convert(Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(source, targetClass);
    }
}
