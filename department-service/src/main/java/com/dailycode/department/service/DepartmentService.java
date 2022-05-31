package com.dailycode.department.service;

import com.dailycode.department.model.Department;
import com.dailycode.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private Environment environment;

    @Autowired
    private DepartmentRepository departmentRepository;

    public String backendPort() {
        System.out.println("Inside DepartmentController::backendPort...");
        String serverPort = environment.getProperty("local.server.port");
        System.out.println("Port : " + serverPort);
        return "Hello form Backend!!! " + " Host : localhost " + " :: Port : " + serverPort;
    }

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }

    public List<Department> allDepartments() {
        log.info("Inside allDepartments of DepartmentService");
        return departmentRepository.findAll();
    }
}