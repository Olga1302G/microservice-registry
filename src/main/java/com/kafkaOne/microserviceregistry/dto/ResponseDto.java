package com.kafkaOne.microserviceregistry.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDto {

    private Long paymentId;

    private List<RegistryDto> history;
}
