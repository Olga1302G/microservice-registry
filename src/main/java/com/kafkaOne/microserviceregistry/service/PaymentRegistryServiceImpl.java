package com.kafkaOne.microserviceregistry.service;

import com.kafkaOne.microserviceregistry.model.PaymentRegistry;
import com.kafkaOne.microserviceregistry.repositories.PaymentRegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentRegistryServiceImpl implements PaymentRegistryService {

    private PaymentRegistryRepository paymentRepository;

    @Autowired
    public PaymentRegistryServiceImpl(PaymentRegistryRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<PaymentRegistry> findPaymentByPaymentId(Long paymentId) {
        List<PaymentRegistry> payments = new ArrayList<>();
        payments = paymentRepository.findPaymentByPaymentId(paymentId);
        return payments;
    }
}
