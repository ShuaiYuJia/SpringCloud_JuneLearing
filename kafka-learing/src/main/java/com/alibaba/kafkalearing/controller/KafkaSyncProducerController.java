package com.alibaba.kafkalearing.controller;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @Author: ShuaiYu_Jia
 * @Data: 2022/6/2
 * @Description:
 */
@RestController
public class KafkaSyncProducerController {

    @Autowired
    private KafkaTemplate<Integer, String> template;

    @RequestMapping("send/sync/{message}")
    public String send(@PathVariable String message){
        final ListenableFuture<SendResult<Integer, String>> future = template.send("topic-spring-01", 0, 0, message);
        //同步发送消息
        try {
            //获取消息的发送结果
            final SendResult<Integer, String> sendResult = future.get();
//            读取发送结果中的数据
            final RecordMetadata metadata = sendResult.getRecordMetadata();

            System.out.println(metadata.topic() + "\t" + metadata.partition() + "\t" + metadata.offset());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return "success";

    }
}
