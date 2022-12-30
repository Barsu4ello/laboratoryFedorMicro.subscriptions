package com.cvetkov.fedor.laboratoryworkmicro.subscriptions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubscriptionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubscriptionsApplication.class, args);
    }

}
