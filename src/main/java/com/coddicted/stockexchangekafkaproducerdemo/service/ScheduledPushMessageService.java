package com.coddicted.stockexchangekafkaproducerdemo.service;

import com.coddicted.stockexchangekafkaproducerdemo.model.Company;
import com.coddicted.stockexchangekafkaproducerdemo.model.Message;
import com.coddicted.stockexchangekafkaproducerdemo.util.StockExchangeUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.ZonedDateTime;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ScheduledPushMessageService {

    private KafkaTemplate<String, Message> kafkaTemplate;

    @Scheduled(fixedRate = 5000)
    public void sendMessage() {
        Company company = StockExchangeUtil.getRandomCompany();
        int price = StockExchangeUtil.getRandomPrice();
//        kafkaTemplate.send("stocks",
//                new Message(company.getCompanyId(), company.getCompanyName(), price, ZonedDateTime.now()));
        ListenableFuture<SendResult<String, Message>> future =
                kafkaTemplate.send("stocks",
                        new Message(company.getCompanyId(),
                        company.getCompanyName(),
                        price,
                        ZonedDateTime.now()));

        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, Message> result) {
                System.out.println("Sent message with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message due to : " + ex.getMessage());
            }
        });
    }
}
