package com.af.projectservice.controller;

import com.af.projectservice.entity.Department;
import com.af.projectservice.service.DepartmentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    public List<Department> fallbackListDepartments(){
        System.out.println("Fall back calleddddddddddddddd");
        List<Department> d = new ArrayList<Department>();

        return d;
    }


    @GetMapping("/")
    @HystrixCommand(fallbackMethod = "fallbackListDepartments")
    public List<Department> listDepartments() {
        System.out.println("hiiiiiii");
        System.out.println (departmentService.getDepartments());
        List<Department> departments =  departmentService.getDepartments();
//		departments.forEach(dep -> System.out.println(dep));
        return departments;

    }
}
