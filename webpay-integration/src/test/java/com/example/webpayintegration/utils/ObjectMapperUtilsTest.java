package com.example.webpayintegration.utils;

import com.example.webpayintegration.dto.request.CreateTransactionRequestDto;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ObjectMapperUtilsTest {

    @Test
    void convert() {

        Map<String, String > createTransactionParams = new HashMap<>();
        createTransactionParams.put("amount", "100");

        CreateTransactionRequestDto responseDto = ObjectMapperUtils.convert(createTransactionParams, CreateTransactionRequestDto.class);

        assertNotNull(responseDto);
        assertEquals(responseDto.getAmount(), "100");
    }
}