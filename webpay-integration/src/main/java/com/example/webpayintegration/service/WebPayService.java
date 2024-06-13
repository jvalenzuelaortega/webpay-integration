package com.example.webpayintegration.service;

import com.example.webpayintegration.dto.request.CaptureTransactionRequestDto;
import com.example.webpayintegration.dto.request.CreateTransactionRequestDto;
import com.example.webpayintegration.dto.response.CancelTransactionResponseDto;
import com.example.webpayintegration.dto.response.CaptureTransactionResponseDto;
import com.example.webpayintegration.dto.response.ConfirmTransactionResponseDto;
import com.example.webpayintegration.dto.response.CreateTransactionResponseDto;
import com.example.webpayintegration.dto.response.StatusTransactionResponseDto;

public interface WebPayService {

    CreateTransactionResponseDto createTransaction(CreateTransactionRequestDto createTransactionDto);
    ConfirmTransactionResponseDto confirmTransaction(String token);
    StatusTransactionResponseDto getTransaction(String token);
    CancelTransactionResponseDto cancelTransaction(String token, Double amount);
    CaptureTransactionResponseDto captureTransaction(CaptureTransactionRequestDto captureTransactionRequestDto);
}
