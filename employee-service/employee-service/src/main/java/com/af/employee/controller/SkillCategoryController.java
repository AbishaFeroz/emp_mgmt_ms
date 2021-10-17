package com.af.employee.controller;

import com.af.employee.entity.Designation;
import com.af.employee.entity.SkillCategory;
import com.af.employee.service.DesignationService;
import com.af.employee.service.SkillCategoryService;
import com.af.employee.vo.DesignationVo;
import com.af.employee.vo.SkillCategoryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Slf4j
@RequestMapping("emp/skillCategory")
public class SkillCategoryController {

    @Autowired
    SkillCategoryService service;

    @GetMapping("/list")
    public List<SkillCategory> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillCategoryVo> get(@PathVariable Long id) {
        SkillCategory skillCategory = service.get(id);
        return new ResponseEntity<SkillCategoryVo>(new SkillCategoryVo(skillCategory), HttpStatus.OK);
    }


    @PostMapping("/save")
    public void save(@RequestBody SkillCategory skillCategory) {

        service.save(skillCategory);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
