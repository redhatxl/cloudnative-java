package com.xuel.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


// 定义远程feign接口
@FeignClient("springbootinit")
public interface ServiceDemoFeign {

    // 调用服务提提供者  springbootinit 的 /services 接口获取数据
    @RequestMapping("/services")
    String remotesvc();
}
