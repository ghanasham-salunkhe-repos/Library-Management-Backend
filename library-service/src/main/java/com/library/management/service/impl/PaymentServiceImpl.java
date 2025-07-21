package com.library.management.service.impl;

import com.library.management.dto.outputs.PaymentInformationDTO;
import com.library.management.mapper.LibraryManagementMapper;
import com.library.management.repositories.PaymentRepository;
import com.library.management.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<PaymentInformationDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream().map(LibraryManagementMapper::paymentToPaymentInformationDTO).toList();
    }
}
