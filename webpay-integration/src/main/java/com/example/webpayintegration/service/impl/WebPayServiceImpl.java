package com.example.webpayintegration.service.impl;

import cl.transbank.webpay.exception.TransactionCaptureException;
import cl.transbank.webpay.exception.TransactionCommitException;
import cl.transbank.webpay.exception.TransactionCreateException;
import cl.transbank.webpay.exception.TransactionRefundException;
import cl.transbank.webpay.exception.TransactionStatusException;
import com.example.webpayintegration.dto.CaptureTransactionDto;
import com.example.webpayintegration.dto.CreateTransactionDto;
import com.example.webpayintegration.dto.request.CaptureTransactionRequestDto;
import com.example.webpayintegration.dto.request.CreateTransactionRequestDto;
import com.example.webpayintegration.dto.response.CancelTransactionResponseDto;
import com.example.webpayintegration.dto.response.CaptureTransactionResponseDto;
import com.example.webpayintegration.dto.response.ConfirmTransactionResponseDto;
import com.example.webpayintegration.dto.response.CreateTransactionResponseDto;
import com.example.webpayintegration.dto.response.StatusTransactionResponseDto;
import com.example.webpayintegration.sdk.WebPayClient;
import com.example.webpayintegration.service.WebPayService;
import com.example.webpayintegration.utils.ModelMapperUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WebPayServiceImpl implements WebPayService {

    private final WebPayClient webPayClient;

    public WebPayServiceImpl(WebPayClient webPayClient) {
        this.webPayClient = webPayClient;
    }

    @Override
    public CreateTransactionResponseDto createTransaction(CreateTransactionRequestDto createTransactionRequestDto) {
        try {
            CreateTransactionDto createTransactionDto = ModelMapperUtils.convert(createTransactionRequestDto, CreateTransactionDto.class);
            return webPayClient.createTransaction(createTransactionDto);
        } catch (TransactionCreateException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ConfirmTransactionResponseDto confirmTransaction(String token) {
        try {
            return webPayClient.confirmTransaction(token);
        } catch (TransactionCommitException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public StatusTransactionResponseDto getTransaction(String token) {
        try {
            return webPayClient.getTransaction(token);
        } catch (IOException | TransactionStatusException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CancelTransactionResponseDto cancelTransaction(String token, Double amount) {
        try {
            return webPayClient.cancelTransaction(token, amount);
        } catch (TransactionRefundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CaptureTransactionResponseDto captureTransaction(CaptureTransactionRequestDto captureTransactionRequestDto) {
        try {
            CaptureTransactionDto captureTransactionDto = ModelMapperUtils.convert(captureTransactionRequestDto, CaptureTransactionDto.class);
            return webPayClient.captureTransaction(captureTransactionDto);
        } catch (TransactionCaptureException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
