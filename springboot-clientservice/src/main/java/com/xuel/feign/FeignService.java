package com.xuel.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


// 发现spring 名称空间服务
// 发现springother 其他名称空间服务
//@FeignClient(value = "springbootinit",url = "http://springbootinit.springother.svc.cluster.local:8080/")
@FeignClient(value = "springbootinit",url = "http://springbootinit.spring.svc.cluster.local:8080/")
public interface FeignService {

    @RequestMapping("/services")
    String remoteSvc();
}
