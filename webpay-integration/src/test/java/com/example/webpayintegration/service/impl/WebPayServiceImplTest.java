package com.example.webpayintegration.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.webpayintegration.dto.request.CaptureTransactionRequestDto;
import com.example.webpayintegration.dto.request.CreateTransactionRequestDto;
import com.example.webpayintegration.dto.response.CancelTransactionResponseDto;
import com.example.webpayintegration.dto.response.CaptureTransactionResponseDto;
import com.example.webpayintegration.dto.response.ConfirmTransactionResponseDto;
import com.example.webpayintegration.dto.response.CreateTransactionResponseDto;
import com.example.webpayintegration.dto.response.StatusTransactionResponseDto;
import com.example.webpayintegration.sdk.WebPayClient;

import lombok.SneakyThrows;

class WebPayServiceImplTest {

	@InjectMocks
	private WebPayServiceImpl webPayServiceImpl;

	@Mock
	private WebPayClient webPayClient;
	
	@BeforeEach
	void setUp() {
		webPayClient = mock(WebPayClient.class);
		webPayServiceImpl = new WebPayServiceImpl(webPayClient);
	}

	@Test
	@SneakyThrows
	void createTransaction() {
		// Arrange
		CreateTransactionRequestDto createTransactionRequestDto = new CreateTransactionRequestDto();
		CreateTransactionResponseDto createTransactionResponseDto = CreateTransactionResponseDto.builder().build();
		when(webPayClient.createTransaction(any())).thenReturn(createTransactionResponseDto);

		// Act
		CreateTransactionResponseDto responseDto = webPayServiceImpl.createTransaction(createTransactionRequestDto);

		// Assert
		assertNotNull(responseDto);
	}

	@Test
	@SneakyThrows
	void confirmTransaction() {
		// Arrange
		String token = "token123456";
		ConfirmTransactionResponseDto confirmTransactionResponseDto = ConfirmTransactionResponseDto.builder().build();
		when(webPayClient.confirmTransaction(anyString())).thenReturn(confirmTransactionResponseDto);

		// Act
		ConfirmTransactionResponseDto responseDto = webPayServiceImpl.confirmTransaction(token);

		// Assert
		assertNotNull(responseDto);
	}

	@Test
	@SneakyThrows
	void getTransaction() {
		// Arrange
		String token = "token123456";
		StatusTransactionResponseDto statusTransactionResponseDto = StatusTransactionResponseDto.builder().build();
		when(webPayClient.getTransaction(anyString())).thenReturn(statusTransactionResponseDto);

		// Act
		StatusTransactionResponseDto responseDto = webPayServiceImpl.getTransaction(token);

		// Assert
		assertNotNull(responseDto);
	}

	@Test
	@SneakyThrows
	void cancelTransaction() {
		// Arrange
		String token = "token123456";
		Double amount = 100.0D;
		CancelTransactionResponseDto cancelTransactionResponseDto = CancelTransactionResponseDto.builder().build();
		when(webPayClient.cancelTransaction(token, amount)).thenReturn(cancelTransactionResponseDto);

		// Act
		CancelTransactionResponseDto responseDto = webPayServiceImpl.cancelTransaction(token, amount);

		// Assert
		assertNotNull(responseDto);
	}

	@Test
	@SneakyThrows
	void captureTransaction() {
		// Arrange
		CaptureTransactionRequestDto captureTransactionRequestDto = new CaptureTransactionRequestDto();
		CaptureTransactionResponseDto captureTransactionResponseDto = CaptureTransactionResponseDto.builder().build();
		when(webPayClient.captureTransaction(any())).thenReturn(captureTransactionResponseDto);
		
		// Act
		CaptureTransactionResponseDto responseDto = webPayServiceImpl.captureTransaction(captureTransactionRequestDto);
		
		// Assert
		assertNotNull(responseDto);
	}
}