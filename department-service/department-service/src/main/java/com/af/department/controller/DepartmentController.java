package com.af.department.controller;

import java.util.List;

import com.af.department.entity.ProjectDepartment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.af.department.entity.Department;
import com.af.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;


	@GetMapping("/")

	public ProjectDepartment list() {
		
		List<Department> departments =  departmentService.findAll();
		ProjectDepartment projectDepartment = new ProjectDepartment();
		projectDepartment.setDepartments(departments);

		return projectDepartment;

	}
	
	@PostMapping("/")
	public Department save(@RequestBody Department department) {
		log.info("In controller-Save");
		System.out.println(department);
		Department d = departmentService.save(department);
		System.out.println(d);
		return d;
	}
	
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long id) {
		log.info("In Controller getId");
		
		return departmentService.findDepartmentById(id);
		
	}
	

}
