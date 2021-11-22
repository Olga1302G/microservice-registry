package com.kafkaOne.microserviceregistry.service;


import com.kafkaOne.microserviceregistry.model.PaymentRegistry;


import java.util.List;

public interface PaymentRegistryService {

    List<PaymentRegistry> findPaymentByPaymentId(Long paymentId);
}
