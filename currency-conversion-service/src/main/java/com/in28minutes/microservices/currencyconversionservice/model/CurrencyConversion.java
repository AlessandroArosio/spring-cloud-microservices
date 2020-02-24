package com.in28minutes.microservices.currencyconversionservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Alessandro Arosio - 24/02/2020 17:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyConversion {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal calculatedAmount;
    private Integer port;
}
