package com.af.employee.service;

import com.af.employee.entity.SkillCategory;
import com.af.employee.repository.SkillCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SkillCategoryService {

    @Autowired
    private SkillCategoryRepository repo;

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public void save(SkillCategory skillCategory) {
        repo.save(skillCategory);
    }

    public SkillCategory get(Long id) {
        return repo.findById(id).get();
    }

    public List<SkillCategory> list() {
        List<SkillCategory> skillCategories = new ArrayList<SkillCategory>();
        repo.findAll().forEach(obj -> skillCategories.add(obj));
        return skillCategories;
    }
}
