package com.example.webpayintegration.service.impl;

import cl.transbank.webpay.exception.*;
import com.example.webpayintegration.dto.CaptureTransactionDto;
import com.example.webpayintegration.dto.CreateTransactionDto;
import com.example.webpayintegration.sdk.WebPayClient;
import com.example.webpayintegration.service.WebPayService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WebPayServiceImpl implements WebPayService {

    private final WebPayClient webPayClient;

    public WebPayServiceImpl(WebPayClient webPayClient) {
        this.webPayClient = webPayClient;
    }

    @Override
    public Object createTransaction(CreateTransactionDto createTransactionDto) {
        try {
            return webPayClient.createTransaction(createTransactionDto);
        } catch (TransactionCreateException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object confirmTransaction(String token) {
        try {
            return webPayClient.confirmTransaction(token);
        } catch (TransactionCommitException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object getTransaction(String token) {
        try {
            return webPayClient.getTransaction(token);
        } catch (IOException | TransactionStatusException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object cancelTransaction(String token, Double amount) {
        try {
            return webPayClient.cancelTransaction(token, amount);
        } catch (TransactionRefundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object captureTransaction(CaptureTransactionDto captureTransactionDto) {
        try {
            return webPayClient.captureTransaction(captureTransactionDto);
        } catch (TransactionCaptureException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
