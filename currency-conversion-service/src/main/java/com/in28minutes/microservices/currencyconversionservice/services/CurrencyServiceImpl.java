package com.in28minutes.microservices.currencyconversionservice.services;

import com.in28minutes.microservices.currencyconversionservice.model.CurrencyConversion;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alessandro Arosio - 24/02/2020 17:50
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private String uri = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";

    @Override
    public CurrencyConversion getCurrency(String from, String to) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversion> response = restTemplate.getForEntity(uri, CurrencyConversion.class, uriVariables);
        log.info("Response: {}", response.getBody());
        return response.getBody();
    }
}
