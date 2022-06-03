package com.alibaba.consumer.controller;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @Author: ShuaiYu_Jia
 * @Data: 2022/6/3
 * @Description:
 */

@Configuration
public class KafkaConsumer {


    @KafkaListener(topics = "XinXin")
    public String xiaofei(String msg){

        System.out.println("已成功接收到"+msg);
        return "已成功接收到"+msg;



    }



}
