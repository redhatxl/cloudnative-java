package com.xuel.service.impl;

import com.xuel.feign.ServiceDemoFeign;
import com.xuel.service.FeignDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignDemoServiceImpl implements FeignDemoService {

    @Autowired
    private ServiceDemoFeign serviceDemoFeign;

    // 实现svc
    @Override
    public String svc() {
        return serviceDemoFeign.remotesvc();
    }
}
