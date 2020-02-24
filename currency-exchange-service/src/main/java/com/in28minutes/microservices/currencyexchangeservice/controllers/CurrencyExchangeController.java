package com.in28minutes.microservices.currencyexchangeservice.controllers;

import com.in28minutes.microservices.currencyexchangeservice.model.ExchangeValue;
import com.in28minutes.microservices.currencyexchangeservice.repository.ExchangeValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alessandro Arosio - 23/02/2020 09:30
 */
@RestController
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final Environment environment;
    private final ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String to, @PathVariable String from) {
        ExchangeValue result = exchangeValueRepository.findByFromAndTo(from, to);
        result.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
        return result;
    }
}
