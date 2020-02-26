package com.in28minutes.microservices.limitsservice.controllers;

import com.in28minutes.microservices.limitsservice.bean.LimitConfiguration;
import com.in28minutes.microservices.limitsservice.config.LimitProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alessandro Arosio - 22/02/2020 15:18
 */
@RestController
@RequiredArgsConstructor
public class LimitsConfigurationController {

    private final LimitProperties limitProperties;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfigurations() {
        return LimitConfiguration.builder()
                .maximum(limitProperties.getMaximum())
                .minimum(limitProperties.getMimimum())
                .build();
    }

    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
    public LimitConfiguration getConfig() {
        throw new RuntimeException("Hi test!");
    }

    public LimitConfiguration fallbackRetrieveConfiguration() {
        return LimitConfiguration.builder()
                .minimum(12)
                .maximum(555)
                .build();
    }
}
