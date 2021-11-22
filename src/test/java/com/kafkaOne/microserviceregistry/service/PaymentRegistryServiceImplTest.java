package com.kafkaOne.microserviceregistry.service;

import com.kafkaOne.microserviceregistry.model.PaymentRegistry;
import com.kafkaOne.microserviceregistry.repositories.PaymentRegistryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PaymentRegistryServiceImplTest {

    @MockBean
    private PaymentRegistryRepository repository;

    @Autowired
    private PaymentRegistryService paymentRegistryService;

    @Test
    public void findPaymentByPaymentIdTest(){
        when(repository.findPaymentByPaymentId(any()))
                .thenReturn(Stream.of(
                                        new PaymentRegistry(1L, 1L, "15.10.2021", "1280"),
                                        new PaymentRegistry(2L, 1L, "15.08.2021", "7080"),
                                        new PaymentRegistry(3L, 1L, "05.12.2021", "15000")
                                )
                                .collect(Collectors.toList())
                );
        List<PaymentRegistry> paymentRegistryList = repository.findPaymentByPaymentId(1L);
        assertThat(paymentRegistryList.get(0).getPaymentId()).isEqualTo(1L);
        assertNotNull(paymentRegistryList, "failure - expected that bankClient not null");
        assertTrue(paymentRegistryList.size() > 0, "failure - expected that size of list of company greater than 0");

    }
}
