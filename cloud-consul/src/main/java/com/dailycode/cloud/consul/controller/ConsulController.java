package com.dailycode.cloud.consul.controller;

import com.dailycode.cloud.consul.model.ConsulUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ConsulController {

    @Autowired
    private ConsulUser consulUser;

    @GetMapping ("/user")
    public ConsulUser getValutUser() {
        log.info("valut user: {} and password: {}", consulUser.getUsername(), consulUser.getPassword());
        return consulUser;
    }
}
