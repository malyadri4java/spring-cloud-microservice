package com.dailycode.cloud.consul.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ConfigurationProperties (prefix = "my")
public class ConsulUser {

    private String username;

    private String password;

}
