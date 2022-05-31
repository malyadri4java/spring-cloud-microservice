package com.dailycode.user.remotecall;

import com.dailycode.user.VO.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "department-service", url = "localhost:9001")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentRemoteCallService {
    @GetMapping("/department/{departmentId}")
    public Department getDepartment(@PathVariable Long departmentId);
}
