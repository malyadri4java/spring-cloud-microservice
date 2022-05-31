package com.dailycode.ribbon.service;

import com.dailycode.ribbon.model.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class RibbonDepartmentService {
    // You can use host & port (like, localhost:9001, send-req-to-server, department-service)
    private final String BASE_URL = "http://send-req-to-server/department";

    @Autowired
    private RestTemplate restTemplate;

    public String backend() {
        System.out.println("Inside DepartmentController::backend...");
        return restTemplate.getForObject(getBaseUrl("port"), String.class);
    }

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment of RibbonDepartmentService");
        Department newDepartment = restTemplate.postForObject(getBaseUrl(), department, Department.class);
        return newDepartment;
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside getDepartment of UserService");
        Department department = restTemplate.getForObject(getBaseUrl(String.valueOf(departmentId)), Department.class);
        return department;
    }

    public List<Department> allDepartments() {
        log.info("Inside allDepartments of UserService");
        Department[] departments = restTemplate.getForObject(getBaseUrl(), Department[].class);
        return Arrays.asList(departments).stream().collect(Collectors.toList());
    }

    private String getBaseUrl() {
        return getBaseUrl(null);
    }

    private String getBaseUrl(String... path) {
        StringBuffer buffer = new StringBuffer(BASE_URL);
        if (path != null && path.length > 0) {
            for (String str : path) {
                buffer.append("/" + str);
            }
        }
        return buffer.toString();
    }
}