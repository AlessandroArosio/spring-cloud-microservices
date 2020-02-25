package com.in28minutes.microservices.currencyconversionservice.services.feign;

import com.in28minutes.microservices.currencyconversionservice.model.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Alessandro Arosio - 25/02/2020 17:36
 */
//@FeignClient(name = "currency-exchange-service", url = "localhost:8000") // removing hardcoded value
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion retrieveExchangeValue(@PathVariable("to") String to, @PathVariable("from") String from);
}
