package com.in28minutes.microservices.limitsservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alessandro Arosio - 22/02/2020 15:28
 */
@Data
@Configuration
@ConfigurationProperties("limits-service")
public class LimitProperties {
    private Integer mimimum;
    private Integer maximum;
}
