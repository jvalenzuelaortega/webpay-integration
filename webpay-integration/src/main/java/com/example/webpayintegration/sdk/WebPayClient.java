package com.example.webpayintegration.sdk;

import cl.transbank.common.IntegrationApiKeys;
import cl.transbank.common.IntegrationCommerceCodes;
import cl.transbank.common.IntegrationType;
import cl.transbank.webpay.common.WebpayOptions;
import cl.transbank.webpay.exception.TransactionCaptureException;
import cl.transbank.webpay.exception.TransactionCommitException;
import cl.transbank.webpay.exception.TransactionCreateException;
import cl.transbank.webpay.exception.TransactionRefundException;
import cl.transbank.webpay.exception.TransactionStatusException;
import cl.transbank.webpay.webpayplus.WebpayPlus;
import cl.transbank.webpay.webpayplus.responses.*;
import com.example.webpayintegration.dto.CaptureTransactionDto;
import com.example.webpayintegration.dto.CreateTransactionDto;
import com.example.webpayintegration.dto.response.CancelTransactionResponseDto;
import com.example.webpayintegration.dto.response.CaptureTransactionResponseDto;
import com.example.webpayintegration.dto.response.ConfirmTransactionResponseDto;
import com.example.webpayintegration.dto.response.CreateTransactionResponseDto;
import com.example.webpayintegration.dto.response.StatusTransactionResponseDto;
import com.example.webpayintegration.utils.ModelMapperUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WebPayClient {

    private final WebpayPlus.Transaction tx;

    public WebPayClient() {
        this.tx = new WebpayPlus.Transaction(new WebpayOptions(IntegrationCommerceCodes.WEBPAY_PLUS, IntegrationApiKeys.WEBPAY, IntegrationType.TEST));
    }

    public CreateTransactionResponseDto createTransaction(CreateTransactionDto createTransactionDto) throws TransactionCreateException, IOException {
        final WebpayPlusTransactionCreateResponse response = tx.create(createTransactionDto.getBuyOrder(), createTransactionDto.getSessionId(),
                createTransactionDto.getAmount(), createTransactionDto.getReturnUrl());

        return CreateTransactionResponseDto.builder()
                .url(response.getUrl())
                .token(response.getToken())
                .build();
    }

    public ConfirmTransactionResponseDto confirmTransaction(String token) throws TransactionCommitException, IOException {
        final WebpayPlusTransactionCommitResponse response = tx.commit(token);

        return ModelMapperUtils.convert(response, ConfirmTransactionResponseDto.class);
    }

    public StatusTransactionResponseDto getTransaction(String token) throws IOException, TransactionStatusException {
        final WebpayPlusTransactionStatusResponse response = tx.status(token);

        return ModelMapperUtils.convert(response, StatusTransactionResponseDto.class);
    }

    public CancelTransactionResponseDto cancelTransaction(String token, Double amount) throws TransactionRefundException, IOException {
        final WebpayPlusTransactionRefundResponse response = tx.refund(token, amount);

        return ModelMapperUtils.convert(response, CancelTransactionResponseDto.class);

    }

    public CaptureTransactionResponseDto captureTransaction(CaptureTransactionDto captureTransactionDto) throws TransactionCaptureException, IOException {
        final WebpayPlusTransactionCaptureResponse response = tx.capture(captureTransactionDto.getToken(), captureTransactionDto.getBuyOrder(),
                captureTransactionDto.getAuthorizationCode(), captureTransactionDto.getAmount());

        return ModelMapperUtils.convert(response, CaptureTransactionResponseDto.class);
    }
}
