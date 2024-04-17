package com.example.webpayintegration.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class StatusTransactionResponseDto {
    private String vci;
    private Double amount;
    private String status;
    private String buyOrder;
    private String sessionId;
    private String cardNumber;
    private String accountingDate;
    private String transactionDate;
    private String authorizationCode;
    private String paymentTypeCode;
    private Byte responseCode;
    private Double installmentsAmount;
    private Byte installmentsNumber;
    private Double balance;
}
