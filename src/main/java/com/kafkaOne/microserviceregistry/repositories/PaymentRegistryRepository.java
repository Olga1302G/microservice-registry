package com.kafkaOne.microserviceregistry.repositories;


import com.kafkaOne.microserviceregistry.model.PaymentRegistry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRegistryRepository extends JpaRepository<PaymentRegistry, Long> {

    @Query("SELECT p FROM PaymentRegistry p WHERE p.paymentId=:paymentId")
    List<PaymentRegistry> findPaymentByPaymentId(@Param("paymentId") Long paymentId);
}
