package com.alibaba.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ShuaiYu_Jia
 * @Data: 2022/6/1
 * @Description: 服务端控制器
 */

@RequestMapping("test")
@RestController
public class TestController {

    @RequestMapping("getName")
    public String getName(){
        return "SpringCould!";
    }

    @RequestMapping("hello")
    public String hello(){
        return "hello, welcome xian";
    }

}
