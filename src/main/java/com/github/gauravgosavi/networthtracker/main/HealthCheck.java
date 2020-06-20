package com.github.gauravgosavi.networthtracker.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class HealthCheck implements HealthIndicator {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public Health health() {

        Health health ;
        String errorCode = check();
        if(errorCode.equals("UP")){
            health = Health.up().build();
        }
        else {
            health = Health.down().withDetail("Error: ", errorCode).build();
        }
        return health;
    }

    private String check() {


        return "";

    }

}
