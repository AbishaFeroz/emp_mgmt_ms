package com.af.department.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.af.department.entity.Department;
import com.af.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department save(Department department) {
		// TODO Auto-generated method stub
		System.out.println("In service-Save");
		Department d =  departmentRepository.save(department);
		System.out.println(d);
		return d;
		
	}

	public Department findDepartmentById(Long id) {
		// TODO Auto-generated method stub
		log.info("In service getId");
		Department d =departmentRepository.findDepartmentById(id);
		log.info("dep"+d);
		return d;
	}

	public List<Department> findAll()   
	{  
	List<Department> departments = new ArrayList<Department>();  
	departmentRepository.findAll().forEach(dep -> departments.add(dep));  
	return departments;  
	}  

}
