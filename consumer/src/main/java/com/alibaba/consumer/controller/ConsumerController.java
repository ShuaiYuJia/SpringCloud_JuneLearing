package com.alibaba.consumer.controller;

import com.alibaba.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ShuaiYu_Jia
 * @Data: 2022/6/1
 * @Description:
 */

@RequestMapping("consumer")
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("getName")
    public String getName(){
        return consumerService.getName() + consumerService.hello();

    }

}
