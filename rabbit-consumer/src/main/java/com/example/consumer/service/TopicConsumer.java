package com.example.consumer.service;

import com.example.consumer.config.AmqpConfiguration;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Rison_Lee on 2020/1/15 14:45.
 * @version 1.0
 */
@Service
public class TopicConsumer {
    /**
     * 消费者1
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.topic.queue", durable = "true"),
            exchange = @Exchange(
                    value = AmqpConfiguration.TOPIC_EXCHANG_QUEUE,
                    ignoreDeclarationExceptions = "true"
            ),
            key = {"key.*"}
    ))
    public void listen(String msg) {
        System.out.println("consumer1（key=key.*） 接收到消息" + msg);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 消费者2 key值不同
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.topic2.queue", durable = "true"),
            exchange = @Exchange(
                    value = AmqpConfiguration.TOPIC_EXCHANG_QUEUE,
                    ignoreDeclarationExceptions = "true"
            ),
            key = {"topic.*"}
    ))
    public void listen2(String msg) {
        System.out.println("consumer2（key = topic.*） 接收到消息：" + msg);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 消费者3 key值不同，区别于消费者2
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.topic3.queue", durable = "true"),
            exchange = @Exchange(
                    value = AmqpConfiguration.TOPIC_EXCHANG_QUEUE,
                    ignoreDeclarationExceptions = "true"
            ),
            key = {"topic.#"}
    ))
    public void listen3(String msg) {
        System.out.println("consumer3（key = topic.#） 接收到消息：" + msg);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
