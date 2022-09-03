package com.xuel.controller;


import com.xuel.service.FeignDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignDemoController {

    @Autowired
    private FeignDemoService feignDemoService;

    // 本服务名称
    @RequestMapping("/")
    public String index() {
        return "服务消费者: springboot-client";
    }

    // 监控检查接口
    @RequestMapping("/health")
    public String health() {
        return "up";
    }

    // 获取服务接口
    @RequestMapping("/clientsvc")
    public String getsvc() {
        return "服务消费者springboot-client 获取数据:" + feignDemoService.svc();
    }
}
