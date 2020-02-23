package com.in28minutes.microservices.currencyexchangeservice.controllers;

import com.in28minutes.microservices.currencyexchangeservice.model.ExchangeValue;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Alessandro Arosio - 23/02/2020 09:30
 */
@RestController
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String to, @PathVariable String from) {
        return ExchangeValue.builder()
                .id(100L)
                .from(from)
                .to(to)
                .conversionMultiple(BigDecimal.valueOf(65))
                .port(Integer.valueOf(environment.getProperty("local.server.port")))
                .build();
    }
}
