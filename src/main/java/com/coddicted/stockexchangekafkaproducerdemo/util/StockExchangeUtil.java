package com.coddicted.stockexchangekafkaproducerdemo.util;


import com.coddicted.stockexchangekafkaproducerdemo.model.Company;

import java.util.List;
import java.util.Random;

public class StockExchangeUtil {
    private static Random random = new Random();
    private final static List<Company> companyList
            = List.of(new Company("FB", "Facebook"),
            new Company("GOOG", "Google"),
            new Company("MSFT", "Microsoft"),
            new Company("AAPL", "Apple"),
            new Company("TSLA", "Tesla"));

    public static Company getRandomCompany(){
        int index = random.nextInt(companyList.size());
        return companyList.get(index);
    }

    public static Company getCompanyById(String id){
        return companyList
                .stream()
                .filter(c -> c.getCompanyId().equals(id))
                .findFirst().get();
    }

    public static int getRandomPrice(){
        int price = 1 + random.nextInt(100);
        return price;
    }
}
