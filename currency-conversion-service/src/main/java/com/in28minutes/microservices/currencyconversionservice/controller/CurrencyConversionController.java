package com.in28minutes.microservices.currencyconversionservice.controller;

import com.in28minutes.microservices.currencyconversionservice.model.CurrencyConversion;
import com.in28minutes.microservices.currencyconversionservice.services.CurrencyService;
import com.in28minutes.microservices.currencyconversionservice.services.feign.CurrencyExchangeServiceProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Alessandro Arosio - 24/02/2020 17:28
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyService currencyService;
    private final CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from,
                                              @PathVariable String to,
                                              @PathVariable BigDecimal quantity) {
        CurrencyConversion currency = currencyService.getCurrency(from, to);
        log.info("{}", currency);
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

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/{quantity}")
    public CurrencyConversion convertCurrencyFeign(@PathVariable String from,
                                              @PathVariable String to,
                                              @PathVariable BigDecimal quantity) {
        CurrencyConversion currency = proxy.retrieveExchangeValue(to, from);

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
