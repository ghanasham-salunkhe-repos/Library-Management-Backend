package com.library.management.controller;

import com.library.management.dto.outputs.PaymentInformationDTO;
import com.library.management.service.PaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Payment Management", description = "Payment realted endpoints")
@RestController
@RequestMapping("/api/payments")
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("")
    ResponseEntity<List<PaymentInformationDTO>> getAllReviews() {

        log.info("[GET][/api/payments]get all reviews");
        return ResponseEntity.ok(paymentService.getAllPayments());
    }
}
