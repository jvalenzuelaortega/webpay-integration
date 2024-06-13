package com.example.webpayintegration.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
		createTransactionRequestDto.setBuyOrder("burOrder");
		createTransactionRequestDto.setSessionId("sessionId");
		createTransactionRequestDto.setAmount("1000");
		createTransactionRequestDto.setReturnUrl("http://localhost:8080/return");

		CreateTransactionResponseDto createTransactionResponseDto = CreateTransactionResponseDto.builder().build();
		createTransactionResponseDto.setToken("token");
		createTransactionResponseDto.setUrl("http://webpay.cl/transaction");

		when(webPayClient.createTransaction(any())).thenReturn(createTransactionResponseDto);

		// Act
		CreateTransactionResponseDto responseDto = webPayServiceImpl.createTransaction(createTransactionRequestDto);

		// Assert
		assertNotNull(responseDto);
		assertEquals("token", responseDto.getToken());
		assertEquals("http://webpay.cl/transaction", responseDto.getUrl());
	}

	@Test
	@SneakyThrows
	void confirmTransaction() {
		// Arrange
		String token = "token";
		ConfirmTransactionResponseDto confirmTransactionResponseDto = ConfirmTransactionResponseDto.builder()
				.vci("vci")
				.amount(100.0D)
				.status("status")
				.buyOrder("buy_order_1234")
				.sessionId("session_id_1234")
				.cardNumber("123456")
				.accountingDate("2024/02/02")
				.transactionDate("2024/02/02")
				.build();
		when(webPayClient.confirmTransaction(anyString())).thenReturn(confirmTransactionResponseDto);

		// Act
		ConfirmTransactionResponseDto responseDto = webPayServiceImpl.confirmTransaction(token);

		// Assert
		assertNotNull(responseDto);
		assertEquals("vci", responseDto.getVci());
		assertEquals(100.0D, responseDto.getAmount());
		assertEquals("status", responseDto.getStatus());
		assertEquals("buy_order_1234", responseDto.getBuyOrder());
		assertEquals("session_id_1234", responseDto.getSessionId());
		assertEquals("123456", responseDto.getCardNumber());
		assertEquals("2024/02/02", responseDto.getAccountingDate());
	}

	@Test
	@SneakyThrows
	void getTransaction() {
		// Arrange
		String token = "token";
		StatusTransactionResponseDto statusTransactionResponseDto = StatusTransactionResponseDto.builder()
				.vci("vci")
				.amount(100.0D)
				.status("status")
				.buyOrder("buy_order_1234")
				.sessionId("session_id_1234")
				.cardNumber("123456")
				.accountingDate("2024/02/02")
				.transactionDate("2024/02/02")
				.build();
		when(webPayClient.getTransaction(anyString())).thenReturn(statusTransactionResponseDto);

		// Act
		StatusTransactionResponseDto responseDto = webPayServiceImpl.getTransaction(token);

		// Assert
		assertNotNull(responseDto);
		assertEquals("vci", responseDto.getVci());
		assertEquals(100.0D, responseDto.getAmount());
		assertEquals("status", responseDto.getStatus());
		assertEquals("buy_order_1234", responseDto.getBuyOrder());
		assertEquals("session_id_1234", responseDto.getSessionId());
		assertEquals("123456", responseDto.getCardNumber());
		assertEquals("2024/02/02", responseDto.getAccountingDate());
	}

	@Test
	@SneakyThrows
	void cancelTransaction() {
		// Arrange
		String token = "token";
		Double amount = 100.0D;
		CancelTransactionResponseDto cancelTransactionResponseDto = CancelTransactionResponseDto.builder()
				.type("type")
				.balance(100.0D)
				.authorizationCode("000")
				.authorizationDate("2024/01/01")
				.nullifiedAmount(100.0D)
				.prepaidBalance(50.0D)
				.build();
		when(webPayClient.cancelTransaction(token, amount)).thenReturn(cancelTransactionResponseDto);

		// Act
		CancelTransactionResponseDto responseDto = webPayServiceImpl.cancelTransaction(token, amount);

		// Assert
		assertNotNull(responseDto);
		assertEquals("type", responseDto.getType());
		assertEquals(100.0D, responseDto.getBalance());
		assertEquals("000", responseDto.getAuthorizationCode());
		assertEquals("2024/01/01", responseDto.getAuthorizationDate());
		assertEquals(100.0D, responseDto.getNullifiedAmount());
		assertEquals(50.0D, responseDto.getPrepaidBalance());
	}

	@Test
	@SneakyThrows
	void captureTransaction() {
		// Arrange
		CaptureTransactionRequestDto captureTransactionRequestDto = new CaptureTransactionRequestDto();
		CaptureTransactionResponseDto captureTransactionResponseDto = CaptureTransactionResponseDto.builder()
				.authorizationCode("000")
				.authorizationDate("2024/01/01")
				.capturedAmount(100.0D)
				.build();
		when(webPayClient.captureTransaction(any())).thenReturn(captureTransactionResponseDto);
		
		// Act
		CaptureTransactionResponseDto responseDto = webPayServiceImpl.captureTransaction(captureTransactionRequestDto);
		
		// Assert
		assertNotNull(responseDto);
		assertEquals("000", responseDto.getAuthorizationCode());
		assertEquals("2024/01/01", responseDto.getAuthorizationDate());
		assertEquals(100.0D, responseDto.getCapturedAmount());
	}
}