package com.example.webpayintegration.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CaptureTransactionRequestDto {
    private String token;
    private String buyOrder;
    private String authorizationCode;
    private String amount;
}
