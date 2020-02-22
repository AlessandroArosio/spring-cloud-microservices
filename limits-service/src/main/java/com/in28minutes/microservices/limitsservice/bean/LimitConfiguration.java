package com.in28minutes.microservices.limitsservice.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alessandro Arosio - 22/02/2020 15:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LimitConfiguration {
    private Integer maximum;
    private Integer minimum;
}
