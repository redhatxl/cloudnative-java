package com.xuel.service.impl;

import com.xuel.feign.FeignService;
import com.xuel.service.SpringBootClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringBootClientServiceImpl implements SpringBootClientService {

    @Autowired
    private FeignService feignService;

    @Override
    public String getSvc() {
        return feignService.remoteSvc();
    }
}
