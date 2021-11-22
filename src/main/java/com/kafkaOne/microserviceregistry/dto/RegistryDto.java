package com.kafkaOne.microserviceregistry.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistryDto {

    private String date;

    private String amount;

}
