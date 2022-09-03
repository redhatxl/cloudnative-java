package com.xuel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ServiceProviderController {

    private final String hostname = System.getenv("HOSTNAME");

    @RequestMapping("/")
    private String index() {
        return "springboot gateway service provider";
    }

    @RequestMapping("/api")
    private String api() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                + ", Pod 名称：" + hostname;
    }

}
