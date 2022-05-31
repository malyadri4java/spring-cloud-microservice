package com.dailycode.ribbon.controller;

import com.dailycode.ribbon.model.Department;
import com.dailycode.ribbon.service.RibbonDepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class RibbonController {

    @Autowired
    private RibbonDepartmentService service;

    @GetMapping("/")
    public String health() {
        return "I am Ok";
    }

    @GetMapping("/department/port")
    public String backend() {
        log.info("Inside backend method of RibbonController");
        return service.backend();
    }

    @PostMapping("/department")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment method of RibbonController");
        return service.saveDepartment(department);
    }

    @GetMapping("/department/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentById method of RibbonController");
        return service.findDepartmentById(departmentId);
    }

    @GetMapping("/department")
    public List<Department> allDepartments() {
        log.info("Inside allDepartments method of RibbonController");
        return service.allDepartments();
    }
}