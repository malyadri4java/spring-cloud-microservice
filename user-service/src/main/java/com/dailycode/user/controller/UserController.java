package com.dailycode.user.controller;

import com.dailycode.user.VO.Department;
import com.dailycode.user.VO.ResponseTemplateVO;
import com.dailycode.user.model.User;
import com.dailycode.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private String port;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController on port :{}", port);
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of UserController on port :{}", port);
        return userService.getUserWithDepartment(userId);
    }

    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId) {
        log.info("Inside getDepartment of UserController on port :{}", port);
        return userService.getDepartment(departmentId);
    }

    @GetMapping
    public List<User> allUsers() {
        log.info("Inside allUsers method of UserController on port :{}", port);
        return userService.allUsers();
    }
}