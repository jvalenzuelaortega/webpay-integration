package com.example.webpayintegration.utils;

import cl.transbank.webpay.webpayplus.responses.WebpayPlusTransactionStatusResponse;
import com.example.webpayintegration.dto.response.ConfirmTransactionResponseDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ModelMapperUtilsTest {

    @Test
    void convert() {
        WebpayPlusTransactionStatusResponse response = new WebpayPlusTransactionStatusResponse();
        response.setAmount(100.0D);

        ConfirmTransactionResponseDto responseDto = ModelMapperUtils.convert(response, ConfirmTransactionResponseDto.class);

        assertNotNull(responseDto);
        assertEquals(responseDto.getAmount(), 100.0D);
    }
}