package com.example.webpayintegration.controller;

import com.example.webpayintegration.dto.request.CaptureTransactionRequestDto;
import com.example.webpayintegration.dto.request.CreateTransactionRequestDto;
import com.example.webpayintegration.service.WebPayService;
import com.example.webpayintegration.utils.ObjectMapperUtils;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class WebPayOperationController {

    private final WebPayService webPayService;
    private static final String REDIRECT_URL = "http://127.0.0.1:5500/webpay-result-test.html?token=%s";

    public WebPayOperationController(WebPayService webPayService) {
        this.webPayService = webPayService;
    }

    @GetMapping("/create-transaction")
    public ResponseEntity<?> createTransaction(@RequestParam Map<String, String> createTransactionParams, HttpServletRequest request){
    	String returnUrl = request.getRequestURL().toString().replace("create","confirm");
    	createTransactionParams.put("returnUrl", returnUrl);
        CreateTransactionRequestDto createTransactionRequestDto = ObjectMapperUtils.convert(createTransactionParams, CreateTransactionRequestDto.class);
        return ResponseEntity.ok().body(webPayService.createTransaction(createTransactionRequestDto));
    }

    @GetMapping("/confirm-transaction")
    public ResponseEntity<?> confirmTransaction(@RequestParam(name = "token_ws") String token){
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", String.format(REDIRECT_URL, token)).body(webPayService.confirmTransaction(token));
    }

    @GetMapping("/get-transaction-status")
    public ResponseEntity<?> getTransactionStatus(@RequestParam(name = "token_ws") String token){
        return ResponseEntity.ok().body(webPayService.getTransaction(token));
    }

    @GetMapping("/cancel-transaction")
    public ResponseEntity<?> cancelTransaction(@RequestParam(name = "token_ws") String token,
                                               @RequestParam(name = "amount") String amount,
                                               HttpServletRequest request){
        Double amountParse = Double.valueOf(amount);
        return ResponseEntity.ok().body(webPayService.cancelTransaction(token, amountParse));
    }

    @GetMapping("/capture-transaction")
    public ResponseEntity<?> captureTransaction(@RequestParam Map<String, String> captureTransactionParams, HttpServletRequest request){
        CaptureTransactionRequestDto captureTransactionRequestDto = ObjectMapperUtils.convert(captureTransactionParams, CaptureTransactionRequestDto.class);
        return ResponseEntity.ok().body(webPayService.captureTransaction(captureTransactionRequestDto));
    }
}
