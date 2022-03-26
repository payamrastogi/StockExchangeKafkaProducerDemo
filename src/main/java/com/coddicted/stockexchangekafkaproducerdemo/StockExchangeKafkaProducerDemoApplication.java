package com.coddicted.stockexchangekafkaproducerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockExchangeKafkaProducerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockExchangeKafkaProducerDemoApplication.class, args);
    }

}
