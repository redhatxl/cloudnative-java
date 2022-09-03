package com.xuel.controller;

import com.xuel.service.SpringBootClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootClientServiceController {

    @Autowired
    private SpringBootClientService clientService;

    @RequestMapping("/")
    private String index() {
        return "spirngboot-clientservice";
    }

    @RequestMapping("/getsvc")
    private String getsvc() {
        return "springboot-clientservice: " + clientService.getSvc();
    }
}
