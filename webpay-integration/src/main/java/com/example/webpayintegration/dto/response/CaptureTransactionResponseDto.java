package com.example.webpayintegration.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CaptureTransactionResponseDto {
    private String authorizationCode;
    private String authorizationDate;
    private Double capturedAmount;
    private Byte responseCode;
}
