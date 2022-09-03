package com.xuel.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "config")
@Component
public class SpringBootConfigProperties {
    private String applicationVersion;

    public String getApplicationVersion() {
        return applicationVersion;
    }
}
