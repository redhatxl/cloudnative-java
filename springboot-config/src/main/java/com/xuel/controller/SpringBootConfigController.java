package com.xuel.controller;

import com.xuel.config.SpringBootConfigProperties;
import com.xuel.config.SpringBootConfigPropertiesSecret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties
public class SpringBootConfigController {

    // -----------------value configmap-----------------
    @Value("${config.applicationVersion}")
    private String applicationVersion;

    @Value("${config.app.domain}")
    private String domain;


    // -----------------value secret-----------------
    @Value("${secret.username}")
    private String username;

    @Value("${secret.password}")
    private String password;

    // -----------------env configmap & secret-----------------
    @Autowired
    private Environment environment;

    // -----------------properties configmap-----------------
    @Autowired
    private SpringBootConfigProperties springBootConfigProperties;

    // -----------------properties secret-----------------
    @Autowired
    private SpringBootConfigPropertiesSecret springBootConfigPropertiesSecret;

    @RequestMapping("/")
    public String index() {
        return "springboot-config 应用";
    }

    // configmap value
    @RequestMapping("/value")
    public String value() {
        return applicationVersion + "|" + domain;
    }

    // configmap properties
    @RequestMapping("/properties")
    public String propertie() {
        return springBootConfigProperties.getApplicationVersion();
    }

    // configmap env
    @RequestMapping("/env")
    public String env() {
        return environment.getProperty("config.applicationVersion") + "|" + environment.getProperty("config.app.domain");
    }

    // secret value
    @RequestMapping("/valuesecret")
    public String values() {
        return username + "|" + password;
    }

    // secret properties
    @RequestMapping("/propertiessecret")
    public String properties() {
        return springBootConfigPropertiesSecret.getUsername() + "|" + springBootConfigPropertiesSecret.getPassword();
    }

    // secret env
    @RequestMapping("/envsecret")
    public String envs() {
        return environment.getProperty("secret.username") + "|" + environment.getProperty("secret.password");
    }
}
