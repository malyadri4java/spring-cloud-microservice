package com.dailycode.department.controller;

import com.dailycode.department.model.Department;
import com.dailycode.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/port")
    public String backendPort() {
        log.info("Inside backendPort method of DepartmentController");
        return departmentService.backendPort();
    }

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }

    @GetMapping
    public List<Department> allDepartments() {
        log.info("Inside allDepartments method of DepartmentController");
        return departmentService.allDepartments();
    }
}