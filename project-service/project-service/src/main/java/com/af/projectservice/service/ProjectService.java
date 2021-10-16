package com.af.projectservice.service;

import java.util.ArrayList;
import java.util.List;

import com.af.projectservice.entity.ProjectDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.af.projectservice.entity.Project;
import com.af.projectservice.repository.ProjectRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;


	public List<Project> findAll() {
		List<Project> projects = new ArrayList<Project>();  
		projectRepository.findAll().forEach(proj -> projects.add(proj));  
		return projects;
	}

	public Project save(Project project) {
		System.out.println("In service-Save");
		Project p =  projectRepository.save(project);
		System.out.println(p);
		return p;
	}

	public Project findProjectById(Long id) {
		log.info("In service getId");
		Project p =projectRepository.findProjectById(id);
		log.info("project"+p);
		return p;
	}
	

	
	

}
