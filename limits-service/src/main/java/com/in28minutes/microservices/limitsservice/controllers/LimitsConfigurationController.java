package com.in28minutes.microservices.limitsservice.controllers;

import com.in28minutes.microservices.limitsservice.bean.LimitConfiguration;
import com.in28minutes.microservices.limitsservice.config.LimitProperties;
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
}
