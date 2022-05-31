package com.dailycode.cloud.consul;

import com.dailycode.cloud.consul.model.ConsulUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = ConsulUser.class)
public class CloudConsulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsulServerApplication.class, args);
    }
}
