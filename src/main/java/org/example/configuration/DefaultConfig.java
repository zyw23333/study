package org.example.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

//@Configuration
//@Order(10)
public class DefaultConfig {
    private final ApplicationContext applicationContext;

    DefaultConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        System.out.println("Default Config create");
    }
}
