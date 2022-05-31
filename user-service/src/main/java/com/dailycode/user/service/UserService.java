package com.dailycode.user.service;

import com.dailycode.user.VO.Department;
import com.dailycode.user.VO.ResponseTemplateVO;
import com.dailycode.user.model.User;
import com.dailycode.user.remotecall.DepartmentRemoteCallService;
import com.dailycode.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@Slf4j
public class UserService {
    // You can use host & port (like, localhost:9001)
    private final String BASE_URL = "http://DEPARTMENT-SERVICE/department";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRemoteCallService remoteCallService;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        vo.setUser(user);
        vo.setDepartment(remoteCallService.getDepartment(user.getDepartmentId()));
        return vo;
    }

    public Department getDepartment(Long departmentId) {
        log.info("Inside getDepartment of UserService");
        Department department = restTemplate.getForObject(getBaseUrl(String.valueOf(departmentId)), Department.class);
        return department;
    }

    public List<User> allUsers() {
        log.info("Inside allUsers of UserService");
        return userRepository.findAll();
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