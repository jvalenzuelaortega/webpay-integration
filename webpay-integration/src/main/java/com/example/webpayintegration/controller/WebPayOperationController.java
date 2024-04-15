package com.example.webpayintegration.controller;

import com.example.webpayintegration.service.WebPayService;
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

    public WebPayOperationController(WebPayService webPayService) {
        this.webPayService = webPayService;
    }

    @GetMapping("/create-transaction")
    public ResponseEntity<?> createTransaction(@RequestParam Map<String, String> createTransactionParams){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/confirm-transaction")
    public ResponseEntity<?> confirmTransaction(@RequestParam String token){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-transaction-status")
    public ResponseEntity<?> getTransactionStatus(@RequestParam String token){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cancel-transaction")
    public ResponseEntity<?> cancelTransaction(@RequestParam String token,
                                               @RequestParam String amount){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/capture-transaction")
    public ResponseEntity<?> captureTransaction(@RequestParam Map<String, String> captureTransactionParams){
        return ResponseEntity.ok().build();
    }
}
