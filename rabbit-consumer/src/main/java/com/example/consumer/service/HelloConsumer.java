package com.example.consumer.service;

import com.example.consumer.config.AmqpConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Rison_Lee on 2020/1/13 9:57.
 * @version 1.0
 */
@Service
@RabbitListener(queues = AmqpConfiguration.TEST_HELLO_SEND)
public class HelloConsumer {

    @RabbitHandler
    public void consumer(String hello){
        System.out.println("Consumer:" + hello);
    }
}
