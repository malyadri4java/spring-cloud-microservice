package com.dailycode.department;

import com.dailycode.department.model.Department;
import com.dailycode.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DepartmentServiceApplication implements CommandLineRunner {

    @Autowired
    private DepartmentService service;

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        service.saveDepartment(new Department(null, "IT", "25th cross street", "IT-001"));
    }
}
