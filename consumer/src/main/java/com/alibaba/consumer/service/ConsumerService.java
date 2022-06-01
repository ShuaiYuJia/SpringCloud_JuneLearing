package com.alibaba.consumer.service;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: ShuaiYu_Jia
 * @Data: 2022/6/1
 * @Description:
 */

//注册子模块名称
@FeignClient(value = "service-provider")
public interface ConsumerService {

    @GetMapping("test/getName")
    public String getName();

    @GetMapping("test/hello")
    public String hello();


}
