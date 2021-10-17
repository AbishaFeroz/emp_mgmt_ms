package com.af.employee.controller;

import com.af.employee.entity.Designation;
import com.af.employee.entity.Employee;
import com.af.employee.service.DesignationService;
import com.af.employee.service.EmployeeService;
import com.af.employee.vo.DesignationVo;
import com.af.employee.vo.EmployeeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


    @RestController
    @Slf4j
    @RequestMapping("emp/designation")
    public class DesignationController {
        @Autowired
        DesignationService service;

        @GetMapping("/list")
        public List<Designation> list() {
            return service.list();
        }

        @GetMapping("/{id}")
        public ResponseEntity<DesignationVo> get(@PathVariable Long id) {
                Designation designation = service.get(id);
                return new ResponseEntity<DesignationVo>(new DesignationVo(designation), HttpStatus.OK);
        }


        @PostMapping("/save")
        public void save(@RequestBody Designation designation) {

            service.save(designation);

        }

        @PutMapping("/{id}")
        public ResponseEntity<?> update(@RequestBody Designation designation, @PathVariable Long id) {
            try {
                Designation existProduct = service.get(id);
                service.save(designation);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            service.delete(id);
        }

    }


