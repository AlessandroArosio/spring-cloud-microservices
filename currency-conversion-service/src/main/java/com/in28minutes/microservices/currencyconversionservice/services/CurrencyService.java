package com.in28minutes.microservices.currencyconversionservice.services;

import com.in28minutes.microservices.currencyconversionservice.model.CurrencyConversion;

/**
 * @author Alessandro Arosio - 24/02/2020 17:49
 */
public interface CurrencyService {
    CurrencyConversion getCurrency(String from, String to);
}
