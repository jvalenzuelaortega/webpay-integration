package com.example.webpayintegration.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CaptureTransactionDto {

    private String token;
    private String buyOrder;
    private String authorizationCode;
    private Double amount;
}
