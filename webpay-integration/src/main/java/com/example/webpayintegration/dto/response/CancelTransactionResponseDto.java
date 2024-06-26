package com.example.webpayintegration.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CancelTransactionResponseDto {
    private String type;
    private Double balance;
    private String authorizationCode;
    private Byte responseCode;
    private String authorizationDate;
    private Double nullifiedAmount;
    private Double prepaidBalance;
}
