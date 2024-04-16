package com.example.webpayintegration.service;

import com.example.webpayintegration.dto.CaptureTransactionDto;
import com.example.webpayintegration.dto.CreateTransactionDto;

public interface WebPayService {

    Object createTransaction(CreateTransactionDto createTransactionDto);
    Object confirmTransaction(String token);
    Object getTransaction(String token);
    Object cancelTransaction(String token, Double amount);
    Object captureTransaction(CaptureTransactionDto captureTransactionDto);
}
