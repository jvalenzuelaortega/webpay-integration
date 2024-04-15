package com.example.webpayintegration.service.impl;

import com.example.webpayintegration.dto.CaptureTransactionDto;
import com.example.webpayintegration.dto.CreateTransactionDto;
import com.example.webpayintegration.service.WebPayService;
import org.springframework.stereotype.Service;

@Service
public class WebPayServiceImpl implements WebPayService {
    @Override
    public Object createTransaction(CreateTransactionDto createTransactionDto) {
        return null;
    }

    @Override
    public Object confirmTransaction(String token) {
        return null;
    }

    @Override
    public Object getTransaction(String token) {
        return null;
    }

    @Override
    public Object cancelTransaction(String token, Integer amount) {
        return null;
    }

    @Override
    public Object captureTransaction(CaptureTransactionDto captureTransactionDto) {
        return null;
    }
}
