package com.xuel.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("secret")
@Component
@Data
public class SpringBootConfigPropertiesSecret {
    private String username;
    private String password;

}
