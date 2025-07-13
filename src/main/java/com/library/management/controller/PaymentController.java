package com.library.management.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Payment Management", description = "Payment realted endpoints")
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
}
