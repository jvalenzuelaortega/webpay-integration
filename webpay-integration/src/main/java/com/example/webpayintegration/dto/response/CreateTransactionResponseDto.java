package com.example.webpayintegration.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateTransactionResponseDto {
    private String url;
    private String token;
}
