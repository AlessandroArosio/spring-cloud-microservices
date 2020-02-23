package com.in28minutes.microservices.currencyexchangeservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Alessandro Arosio - 23/02/2020 09:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ExchangeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;
    private BigDecimal conversionMultiple;

    // for demonstration purposes only. To show which microservice instance is providing the data
    private Integer port;
}
