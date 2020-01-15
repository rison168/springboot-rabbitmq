package com.example.producer.controller;

import com.example.consumer.service.WorkConsumer;
import com.example.producer.service.HelloProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.ws.RequestWrapper;

/**
 * @author Rison_Lee on 2020/1/13 10:43.
 * @version 1.0
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController {
    @Resource
    private HelloProducer helloProducer;

    /**
     * 简单模式
     */
    @RequestMapping("/simple")
    public void simple(){
        helloProducer.send();
    }

    /**
     * work模式
     */
    @RequestMapping("/work")
    public void work(){
       helloProducer.work();
    }

    /**
     * fanout订阅模式
     */
    @RequestMapping("/fanout")
    public void fanout(){
        helloProducer.fanout();
    }

    /**
     * direct订阅模式
     */
    @RequestMapping("/direct")
    public void direct(){
        helloProducer.direct();
    }

    /**
     * topic订阅模式
     */
    @RequestMapping("/topic")
    public void topic(){
        helloProducer.topic();
    }



}
