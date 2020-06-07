package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @auther zzyy
 * @create 2020-02-22 11:57
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.err.println("消费者1号,----->接受到的消息: " + message.getPayload() + "\t  port: " + serverPort);
    }

    @Autowired
    @Output(Sink.INPUT)
    SubscribableChannel subscribableChannel;

//    @PostConstruct
//    public void init() {
//        subscribableChannel.subscribe(message -> {
//            System.err.println("init 里的 subscribe");
//        });
//    }
}
