package com.example.webpayintegration.controller;

import com.example.webpayintegration.dto.response.CancelTransactionResponseDto;
import com.example.webpayintegration.dto.response.CaptureTransactionResponseDto;
import com.example.webpayintegration.dto.response.ConfirmTransactionResponseDto;
import com.example.webpayintegration.dto.response.CreateTransactionResponseDto;
import com.example.webpayintegration.dto.response.StatusTransactionResponseDto;
import com.example.webpayintegration.service.WebPayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class WebPayOperationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WebPayService webPayService;

    @Test
    void createTransaction() throws Exception {
        // Arrange
        CreateTransactionResponseDto mockResponseDto = CreateTransactionResponseDto.builder()
                .url("http://localhost:8080/webpay")
                .token("token")
                .build();
        when(webPayService.createTransaction(any())).thenReturn(mockResponseDto);

        // Act
        this.mockMvc.perform(get("/create-transaction")
                        .param("buyOrder", "buyOrder")
                        .param("sessionId", "sessionId")
                        .param("amount", "100"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("token")));

        // Assert
        verify(webPayService).createTransaction(any());
    }

    @Test
    void confirmTransaction() throws Exception {
        // Arrange
        String token = "token";
        ConfirmTransactionResponseDto mockResponseDto = ConfirmTransactionResponseDto.builder()
                .authorizationCode("123")
                .build();

        when(webPayService.confirmTransaction(token)).thenReturn(mockResponseDto);

        // Act
        this.mockMvc.perform(get("/confirm-transaction")
                        .param("token_ws", token))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(content().string(containsString("123")));

        // Assert
    }

    @Test
    void getTransaction() throws Exception {
        // Arrange
        String token = "token";
        StatusTransactionResponseDto mockResponseDto = StatusTransactionResponseDto.builder()
                .authorizationCode("123")
                .build();

        when(webPayService.getTransaction(token)).thenReturn(mockResponseDto);

        // Act
        this.mockMvc.perform(get("/get-transaction-status")
                .param("token_ws", token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("123")));

        // Assert
    }

    @Test
    void cancelTransaction() throws Exception {
        // Arrange
        String token = "token";
        Double amount = 100.0;
        CancelTransactionResponseDto mockResponseDto = CancelTransactionResponseDto.builder()
                .authorizationCode("123")
                .authorizationDate("2024/01/01")
                .build();

        when(webPayService.cancelTransaction(token, amount)).thenReturn(mockResponseDto);

        // Act
        this.mockMvc.perform(get("/cancel-transaction")
                .param("token_ws", token)
                .param("amount", amount.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("2024/01/01")));

        // Assert
    }

    @Test
    void captureTransaction() throws Exception {
        // Arrange
        CaptureTransactionResponseDto mockResponseDto = CaptureTransactionResponseDto.builder()
                .authorizationCode("123")
                .capturedAmount(100.0D)
                .authorizationDate("2024/01/01")
                .build();

        // Act
        when(webPayService.captureTransaction(any())).thenReturn(mockResponseDto);

        // Assert
        this.mockMvc.perform(get("/capture-transaction")
                        .param("token", "token")
                        .param("buyOrder", "buyOrder")
                        .param("authorizationCode", "123")
                        .param("amount", "100"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("123")));
    }
}
