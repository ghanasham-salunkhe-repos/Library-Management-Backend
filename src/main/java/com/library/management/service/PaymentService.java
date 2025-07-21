package com.library.management.service;

import com.library.management.dto.outputs.PaymentInformationDTO;

import java.util.List;

public interface PaymentService {

    List<PaymentInformationDTO> getAllPayments();
}
