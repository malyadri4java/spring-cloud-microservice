package com.dailycode.sleuth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SleuthZipkinController {
    @Autowired
    private Environment environment;

    @GetMapping("/")
    public String health() {
        return "I am Ok";
    }

    @GetMapping("/port")
    public String backend() {
        System.out.println("Inside SleuthZipkinController::backendPort...");
        String serverPort = environment.getProperty("local.server.port");
        System.out.println("Port : " + serverPort);
        return "Hello form Backend!!! " + " Host : localhost " + " :: Port : " + serverPort;
    }
}
