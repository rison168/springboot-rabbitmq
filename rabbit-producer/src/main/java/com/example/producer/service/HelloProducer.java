package com.example.producer.service;

import com.example.producer.cofig.AmqpConfiguration;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Rison_Lee on 2020/1/13 9:49.
 * @version 1.0
 */
@Service
public class HelloProducer {
    @Resource
    private AmqpTemplate rabbitTemplate;

    /**
     * 简单模型
     */
    public void send() {
        String sendMsg = "hello";
        System.out.println("Producer1 : " + sendMsg);
        this.rabbitTemplate.convertAndSend(AmqpConfiguration.TEST_HELLO_SEND, sendMsg);
    }

    /**
     * work模型
     */
    public void work(){
        for (int i = 1; i <= 10; i++){
            String msg = i + "-> work";
            System.out.println("Producer："+ msg);
            this.rabbitTemplate.convertAndSend(AmqpConfiguration.WORK_MODEL_QUEUE, msg);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * fanout-订阅模型
     */
    public void fanout(){
        String msg = "fanout-订阅模型";
        for (int i = 1; i <= 10; i++){
            System.out.println("fanout : " + msg + i);
            this.rabbitTemplate.convertAndSend(AmqpConfiguration.FANOUT_EXCHANGE_QUEUE, "", msg + i);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 订阅模式-Direct(路由模式)
     */
    public void direct(){
        String msg = "路由模式";
        for (int i = 1; i <=10; i++){
            rabbitTemplate.convertAndSend(AmqpConfiguration.DIRECT_EXCHANG_QUEUE, "direct.routing.key", msg + i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Topic 模式
     */
    public void topic(){
        String msg = "topic模式";
        for (int i = 1; i <= 5; i ++){
             rabbitTemplate.convertAndSend(AmqpConfiguration.TOPIC_EXCHANG_QUEUE, "key." + i, msg + i + " key=key.*" );
             rabbitTemplate.convertAndSend(AmqpConfiguration.TOPIC_EXCHANG_QUEUE, "topic." + i, msg + i + " key=topic.*" );
             rabbitTemplate.convertAndSend(AmqpConfiguration.TOPIC_EXCHANG_QUEUE, "topic." + i + ".test", msg + i + " key=topic.*.test" );
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
