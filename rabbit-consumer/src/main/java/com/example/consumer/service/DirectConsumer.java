package com.example.consumer.service;

import com.example.consumer.config.AmqpConfiguration;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Rison_Lee on 2020/1/15 14:20.
 * @version 1.0
 */
@Service
public class DirectConsumer {
    /**
     * 消费者1
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.direct1.queue", durable = "true"),
            exchange = @Exchange(
                    value = AmqpConfiguration.DIRECT_EXCHANG_QUEUE,
                    ignoreDeclarationExceptions = "true"
            ),
            key = {"direct.routing.key"}
    ))
    public void listen(String msg) {
        System.out.println("consumer1（路由模式1） 接收到消息" + msg);
    }

    /**
     * 消费者2 key值不同
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.direct2.queue", durable = "true"),
            exchange = @Exchange(
                    value = AmqpConfiguration.DIRECT_EXCHANG_QUEUE,
                    ignoreDeclarationExceptions = "true"
            ),
            key = {"direct.routing.key2"}
    ))
    public void listen2(String msg) {
        System.out.println("consumer2（路由模式2） 接收到消息：" + msg);
    }

}
