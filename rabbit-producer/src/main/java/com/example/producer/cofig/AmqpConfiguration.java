package com.example.producer.cofig;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author Rison_Lee on 2020/1/13 14:25.
 * @version 1.0
 */
@Configuration
public class AmqpConfiguration {
    public static final String TEST_HELLO_SEND = "test_hello_send";
    public static final String WORK_MODEL_QUEUE = "work_model_queue";
    public static final String FANOUT_EXCHANGE_QUEUE = "fanout_exchange_queue";
    public static final String DIRECT_EXCHANG_QUEUE = "direct_exchange_queue";

    @Bean
    public Queue isTestHelloSendQueue(){
        return new Queue(TEST_HELLO_SEND);
    }

    @Bean
    public Queue isWorkModelQueue(){
        return new Queue(WORK_MODEL_QUEUE);
    }
}

