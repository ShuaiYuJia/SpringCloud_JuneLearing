package com.alibaba.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ShuaiYu_Jia
 * @Data: 2022/6/3
 * @Description:
 */
@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> template;

    @GetMapping("/shuai/{msg}")
    public String getMsg(@PathVariable String msg){
        template.send("XinXin", 0, "Jia", msg);
        return "ok";
    }
}
