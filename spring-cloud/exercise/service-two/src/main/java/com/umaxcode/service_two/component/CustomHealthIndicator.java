package com.umaxcode.service_two.component;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        double chance = ThreadLocalRandom.current().nextDouble(); // help simulate service downtime
        if (chance > 0.5) {
            return Health.up().build();
        }
        return Health.down().build();
    }
}
