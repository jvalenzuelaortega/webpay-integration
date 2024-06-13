package com.example.webpayintegration.utils;

import org.modelmapper.ModelMapper;

public class ModelMapperUtils {

    public static <T> T convert(Object source, Class<T> destinationClass) {
        if (source == null){
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(source, destinationClass);
    }
}
