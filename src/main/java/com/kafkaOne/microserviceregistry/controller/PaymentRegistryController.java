package com.kafkaOne.microserviceregistry.controller;


import com.kafkaOne.microserviceregistry.dto.RegistryDto;
import com.kafkaOne.microserviceregistry.dto.ResponseDto;
import com.kafkaOne.microserviceregistry.model.PaymentRegistry;
import com.kafkaOne.microserviceregistry.service.PaymentRegistryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.slf4j.SLF4JLogger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/payments")
@Api(value = "hello")
public class PaymentRegistryController {
    private static SLF4JLogger logger ;


    private PaymentRegistryService paymentService;

    @Autowired
    public PaymentRegistryController(PaymentRegistryService paymentService){

        this.paymentService = paymentService;
    }

    @GetMapping("/{paymentId}")
    @ApiOperation(value = "Отправка данных о платежах клиента банка в microservice-integrator")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение информации о суммах платежей"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<ResponseDto> getPayment(@PathVariable("paymentId") Long paymentId){
        List<PaymentRegistry> payments = paymentService.findPaymentByPaymentId(paymentId);
        List<RegistryDto> history = new ArrayList<>();
        history = payments.stream().map(payment -> new RegistryDto(payment.getDate(), payment.getAmount()))
                .collect(Collectors.toList());
        ResponseDto response = new ResponseDto(paymentId, history);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
