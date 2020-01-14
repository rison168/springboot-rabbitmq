package com.example.consumer.service;

import com.example.consumer.config.AmqpConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Rison_Lee on 2020/1/13 15:36.
 * @version 1.0
 */
@Service
public class WorkConsumer {
    /**
     * 消费者1
     * @param msg
     */
    @RabbitListener(queues = AmqpConfiguration.WORK_MODEL_QUEUE)
    public void consumer1(String msg){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("consumer1 : " + msg);
    }

    /**
     * 消费者2
     * @param msg
     */
    @RabbitListener(queues = AmqpConfiguration.WORK_MODEL_QUEUE)
    public void consumer2(String msg){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("consumer2 : " + msg);
    }

}
