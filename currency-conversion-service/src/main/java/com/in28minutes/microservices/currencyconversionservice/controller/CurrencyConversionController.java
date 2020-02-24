package com.in28minutes.microservices.currencyconversionservice.controller;

import com.in28minutes.microservices.currencyconversionservice.model.CurrencyConversion;
import com.in28minutes.microservices.currencyconversionservice.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Alessandro Arosio - 24/02/2020 17:28
 */
@RestController
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyService currencyService;

    @GetMapping("/currency-converter/from/{from}/to/{to}/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from,
                                              @PathVariable String to,
                                              @PathVariable BigDecimal quantity) {
        CurrencyConversion currency = currencyService.getCurrency(from, to);
        return CurrencyConversion.builder()
                .id(currency.getId())
                .from(from)
                .to(to)
                .quantity(quantity)
                .conversionMultiple(currency.getConversionMultiple())
                .calculatedAmount(quantity.multiply(currency.getConversionMultiple()))
                .port(currency.getPort())
                .build();
    }
}
