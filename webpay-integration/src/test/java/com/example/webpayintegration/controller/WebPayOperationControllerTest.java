package com.example.webpayintegration.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.webpayintegration.service.impl.WebPayServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class WebPayOperationControllerTest {

	@Mock
	private WebPayServiceImpl webPayService;
	
	@InjectMocks
	private WebPayOperationController webPayOperationController;

	@BeforeEach
	void setUp() {
		webPayService = mock(WebPayServiceImpl.class);
		webPayOperationController = new WebPayOperationController(webPayService);
	}

	@Test
	void createTransaction() {
		// Arrange
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Map<String, String> params = new HashMap<>();
		params.put("buyOrder", "12345");
		params.put("sessionId", "sesion1234");
		params.put("amount", "100");
		params.put("returnUrl", "http://localhost:8080/create");

		when(webPayService.createTransaction(any())).thenReturn(any());

		// Act
		ResponseEntity<?> responseEntity = webPayOperationController.createTransaction(params, request);

		// Assert
		assertNotNull(responseEntity);
	}

	@Test
	void confirmTransaction() {
		// Arrange
		String token = "12345";

		//when(webPayService.getTransaction(anyString())).thenReturn(any());

		// Act
		ResponseEntity<?> responseEntity = webPayOperationController.confirmTransaction(token);

		// Assert
		assertNotNull(responseEntity);
	}

	@Test
	void getTransactionStatus() {
		// Arrange
		String token = "12345";

		when(webPayService.getTransaction(anyString())).thenReturn(any());

		// Act
		ResponseEntity<?> responseEntity = webPayOperationController.getTransactionStatus(token);

		// Assert
		assertNotNull(responseEntity);
	}

	@Test
	void cancelTransaction() {
		// Arrange
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		String token = "12345";
		String amount = "1000";

		//when(webPayService.cancelTransaction(anyString(), anyDouble())).thenReturn(any());

		// Act
		ResponseEntity<?> responseEntity = webPayOperationController.cancelTransaction(token, amount, request);

		// Assert
		assertNotNull(responseEntity);
	}

	@Test
	void captureTransaction() {
		// Arrange
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Map<String, String> params = new HashMap<>();
		params.put("token", "asdfghjkl1234");
		params.put("buyOrder", "12345");
		params.put("authorizationCode", "123");
		params.put("amount", "100");

		when(webPayService.captureTransaction(any())).thenReturn(any());

		// Act
		ResponseEntity<?> responseEntity = webPayOperationController.captureTransaction(params, request);

		// Assert
		assertNotNull(responseEntity);
	}
}