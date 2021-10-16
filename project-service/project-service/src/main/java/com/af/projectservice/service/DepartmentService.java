package com.af.projectservice.service;

import com.af.projectservice.entity.Department;
import com.af.projectservice.entity.ProjectDepartment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    RestTemplate restTemplate;

    public List<Department> getDepartments(){

        List<Department> departments = new ArrayList<Department>();

        ProjectDepartment projectDepartment =  restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/", ProjectDepartment.class);
        log.info(""+projectDepartment.getDepartments());
        return projectDepartment.getDepartments();


    }
}
