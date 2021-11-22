package com.kafkaOne.microserviceregistry.controller;

import com.kafkaOne.microserviceregistry.dto.RegistryDto;
import com.kafkaOne.microserviceregistry.dto.ResponseDto;
import com.kafkaOne.microserviceregistry.model.PaymentRegistry;
import com.kafkaOne.microserviceregistry.service.PaymentRegistryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(PaymentRegistryController.class)
public class PaymentRegistryControllerTest {


    @Autowired
    private PaymentRegistryController paymentRegistryController;

    @MockBean
    private PaymentRegistryService paymentRegistryService;

    @Autowired
    MockMvc mockMvc;


    @Test
    public void testExistence() throws Exception {
        assertNotNull(paymentRegistryController, "PaymentRegistry Rest controller is null");
    }


    @Test
    public void getClientTest() throws Exception {
        List<RegistryDto> registries = new ArrayList<>();
        RegistryDto paymentRegistry = new RegistryDto("12.10.2020", "2300");
        registries.add(paymentRegistry);

        List<PaymentRegistry> paymentRegistries = new ArrayList<>();
        PaymentRegistry registry = new PaymentRegistry(1L, 1L, "12.10.2020", "2300");
        paymentRegistries.add(registry);
        ResponseDto responseDto = new ResponseDto(1L, registries);

        when(paymentRegistryService.findPaymentByPaymentId(1L)).thenReturn(paymentRegistries);

        ResponseEntity<ResponseDto> response = paymentRegistryController.getPayment(1L);
        assertThat(response.getBody().getPaymentId()).isEqualTo(1L);
        assertThat(response.getBody().getHistory()).isEqualTo(registries);

    }
}
