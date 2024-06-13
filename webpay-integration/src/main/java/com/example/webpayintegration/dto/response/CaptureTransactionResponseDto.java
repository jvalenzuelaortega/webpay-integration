package com.example.webpayintegration.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CaptureTransactionResponseDto {
    private String authorizationCode;
    private String authorizationDate;
    private Double capturedAmount;
    private Byte responseCode;
}
