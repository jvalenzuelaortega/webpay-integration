package com.example.webpayintegration.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateTransactionRequestDto {
    private String buyOrder;
    private String sessionId;
    private String amount;
    private String returnUrl;
}
