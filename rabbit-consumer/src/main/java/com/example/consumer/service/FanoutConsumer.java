package com.example.consumer.service;

import com.example.consumer.config.AmqpConfiguration;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * fanout 消费者
 * @author Rison_Lee on 2020/1/14 12:45.
 * @version 1.0
 */
@Service
public class FanoutConsumer {
    /**
     * 消费者1
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "fanout1.queue", durable = "true"),
            exchange = @Exchange(
                    value = AmqpConfiguration.FANOUT_EXCHANGE_QUEUE,
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void fanoutConsumer1(String msg){
        System.out.println("fanoutConsumer1 :" + msg);
    }

    /**
     * 消费者2
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "fanout2.queue", durable = "true"),
            exchange = @Exchange(
                    value = AmqpConfiguration.FANOUT_EXCHANGE_QUEUE,
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.FANOUT
            )
    ))
    public void fanoutConsumer2(String msg){
        System.out.println("fanoutConsumer2 :" + msg);
    }

}
