package com.example.webpayintegration.sdk;

import cl.transbank.common.IntegrationApiKeys;
import cl.transbank.common.IntegrationCommerceCodes;
import cl.transbank.common.IntegrationType;
import cl.transbank.webpay.common.WebpayOptions;
import cl.transbank.webpay.exception.*;
import cl.transbank.webpay.webpayplus.WebpayPlus;
import cl.transbank.webpay.webpayplus.responses.*;
import com.example.webpayintegration.dto.CaptureTransactionDto;
import com.example.webpayintegration.dto.CreateTransactionDto;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WebPayClient {

    public Object createTransaction(CreateTransactionDto createTransactionDto) throws TransactionCreateException, IOException {
        WebpayPlus.Transaction tx = new WebpayPlus.Transaction(new WebpayOptions(IntegrationCommerceCodes.WEBPAY_PLUS, IntegrationApiKeys.WEBPAY, IntegrationType.TEST));
        final WebpayPlusTransactionCreateResponse response = tx.create(createTransactionDto.getBuyOrder(), createTransactionDto.getSessionId(),
                createTransactionDto.getAmount(), createTransactionDto.getReturnUrl());

        return response;
    }

    public Object confirmTransaction(String token) throws TransactionCommitException, IOException {
        WebpayPlus.Transaction tx = new WebpayPlus.Transaction(new WebpayOptions(IntegrationCommerceCodes.WEBPAY_PLUS, IntegrationApiKeys.WEBPAY, IntegrationType.TEST));
        final WebpayPlusTransactionCommitResponse response = tx.commit(token);

        return response;
    }

    public Object getTransaction(String token) throws IOException, TransactionStatusException {
        WebpayPlus.Transaction tx = new WebpayPlus.Transaction(new WebpayOptions(IntegrationCommerceCodes.WEBPAY_PLUS, IntegrationApiKeys.WEBPAY, IntegrationType.TEST));
        final WebpayPlusTransactionStatusResponse response = tx.status(token);

        return response;
    }

    public Object cancelTransaction(String token, Double amount) throws TransactionRefundException, IOException {
        WebpayPlus.Transaction tx = new WebpayPlus.Transaction(new WebpayOptions(IntegrationCommerceCodes.WEBPAY_PLUS, IntegrationApiKeys.WEBPAY, IntegrationType.TEST));
        final WebpayPlusTransactionRefundResponse response = tx.refund(token, amount);

        return response;

    }

    public Object captureTransaction(CaptureTransactionDto captureTransactionDto) throws TransactionCaptureException, IOException {
        WebpayPlus.Transaction tx = new WebpayPlus.Transaction(new WebpayOptions(IntegrationCommerceCodes.WEBPAY_PLUS_DEFERRED, IntegrationApiKeys.WEBPAY, IntegrationType.TEST));
        final WebpayPlusTransactionCaptureResponse response = tx.capture(captureTransactionDto.getToken(), captureTransactionDto.getBuyOrder(),
                captureTransactionDto.getAuthorizationCode(), captureTransactionDto.getAmount());

        return response;
    }
}
