package com.example.webpayintegration.sdk;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.example.webpayintegration.dto.CaptureTransactionDto;
import com.example.webpayintegration.dto.CreateTransactionDto;
import com.example.webpayintegration.dto.response.CancelTransactionResponseDto;
import com.example.webpayintegration.dto.response.CaptureTransactionResponseDto;
import com.example.webpayintegration.dto.response.ConfirmTransactionResponseDto;
import com.example.webpayintegration.dto.response.CreateTransactionResponseDto;
import com.example.webpayintegration.dto.response.StatusTransactionResponseDto;

import lombok.SneakyThrows;

class WebPayClientTest {
	
	@InjectMocks
	private WebPayClient webPayClient;

    @Test
    @SneakyThrows
    void createTransaction() {
    	// Arrange
    	CreateTransactionDto createTransactionDto = new CreateTransactionDto();
    	
    	// Act
    	CreateTransactionResponseDto responseDto = webPayClient.createTransaction(createTransactionDto);
    	
    	// Assert
    	assertNotNull(responseDto);
    }

    @Test
    @SneakyThrows
    void confirmTransaction() {
    	// Arrange
    	String token = "";
    	
    	// Act
    	ConfirmTransactionResponseDto responseDto = webPayClient.confirmTransaction(token);
    	
    	// Assert
    	assertNotNull(responseDto);
    }

    @Test
    @SneakyThrows
    void getTransaction() {
    	// Arrange
    	String token = "";
    	
    	// Act
    	StatusTransactionResponseDto responseDto = webPayClient.getTransaction(token);
    	
    	// Assert
    	assertNotNull(responseDto);
    	
    }

    @Test
    @SneakyThrows
    void cancelTransaction() {
    	// Arrange
    	String token = "";
    	Double amount = 1000.0D;
    	
    	// Act
    	CancelTransactionResponseDto responseDto = webPayClient.cancelTransaction(token, amount);
    	
    	// Assert
    	assertNotNull(responseDto);
    }

    @Test
    @SneakyThrows
    void captureTransaction() {
    	// Arrange
    	CaptureTransactionDto captureTransactionDto = new CaptureTransactionDto();
    	
    	// Act
    	CaptureTransactionResponseDto responseDto = webPayClient.captureTransaction(captureTransactionDto);
    	
    	// Assert
    	assertNotNull(responseDto);
    }
}