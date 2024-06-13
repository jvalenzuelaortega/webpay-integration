package com.example.webpayintegration.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateTransactionDto {
    private String buyOrder;
    private String sessionId;
    private Double amount;
    private String returnUrl;
}
