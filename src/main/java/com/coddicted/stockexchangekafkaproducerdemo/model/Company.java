package com.coddicted.stockexchangekafkaproducerdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Company {
    private String companyId;
    private String companyName;
}
