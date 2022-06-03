package com.alibaba.kafkalearing.controller;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ShuaiYu_Jia
 * @Data: 2022/6/2
 * @Description:
 */
@RestController
public class KafkaAsyncProducerController {
    @Autowired
    private KafkaTemplate<Integer, String> template;

    @RequestMapping("send/async/{message}")
    public String send(@PathVariable String message){
        final ListenableFuture<SendResult<Integer, String>> future = template.send("topic-spring-01", 0, 1, message);

        // 设置回调函数，异步等待broker端的等待结果
        future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("消息发送失败" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
//                result 为消息的发送结果
                final RecordMetadata metadata = result.getRecordMetadata();
                System.out.println("消息发送成功" + metadata.topic() + "\t" + metadata.partition() + "\t" + metadata.offset());
            }
        });



        return "success";
    }
}
