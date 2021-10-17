package com.af.projectservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.af.projectservice.entity.Department;
import com.af.projectservice.entity.Project;
import com.af.projectservice.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/")
	public List<Project> list() {
		
		List<Project> projects =  projectService.findAll();
		return projects;
		
	}
	
	@PostMapping("/save")
	public Project save(@RequestBody Project project) {
		log.info("In controller-Save");
		System.out.println(project);
		Project proj = projectService.save(project);
		System.out.println(proj);
		return proj;
	}
	
	@GetMapping("/{id}")
	public Project findProjectById(@PathVariable("id") Long id) {
		log.info("In Controller getId");
		
		return projectService.findProjectById(id);
		
	}
	

	
	
	

	

}
