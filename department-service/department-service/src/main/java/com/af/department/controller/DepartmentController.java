package com.af.department.controller;

import java.util.List;

import com.af.department.entity.ProjectDepartment;
import com.af.department.vo.DepartmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;


	@GetMapping("/list")
	public ProjectDepartment list() {
		
		List<Department> departments =  departmentService.findAll();
		System.out.println(departments);
		ProjectDepartment projectDepartment = new ProjectDepartment();
		projectDepartment.setDepartments(departments);
		return projectDepartment;
	}

	@GetMapping("/")
	public List<Department> departments() {

		List<Department> departments =  departmentService.findAll();
		return departments;
	}
	
	@PostMapping("/save")
	public Department save(@RequestBody Department department) {
		log.info("In controller-Save");
		System.out.println(department);
		Department d = departmentService.save(department);
		System.out.println(d);
		return d;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentVo>  findDepartmentById(@PathVariable("id") Long id) {
		log.info("In Controller getId");
		
		Department department =  departmentService.findDepartmentById(id);
		return new ResponseEntity<DepartmentVo>(new DepartmentVo(department), HttpStatus.OK);
		
	}
	

}
