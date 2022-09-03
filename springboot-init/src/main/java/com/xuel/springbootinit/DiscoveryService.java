package com.xuel.springbootinit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class DiscoveryService {

    private final String hostname = System.getenv("HOSTNAME");

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    public String index() {
        return "springboot-init 服务提供者";
    }

    // 提供健康检查接口
    @RequestMapping("/health")
    public String health() {
        return "up";
    }

    //
    @RequestMapping("/services")
    public String service() {
        return discoveryClient.getServices().toString()
                + ", 时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                + ", Pod 名称：" + hostname;
    }
}
