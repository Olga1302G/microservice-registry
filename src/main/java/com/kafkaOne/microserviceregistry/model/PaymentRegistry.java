package com.kafkaOne.microserviceregistry.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class PaymentRegistry implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "paymentid")
    private Long paymentId;

    @Column
    private String date;

    @Column
    private String amount;

    public PaymentRegistry(String date, String amount) {
        this.date = date;
        this.amount = amount;
    }
}
