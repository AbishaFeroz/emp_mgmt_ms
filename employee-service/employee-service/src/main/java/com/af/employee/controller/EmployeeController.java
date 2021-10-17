package com.af.employee.controller;

import com.af.employee.entity.Employee;
import com.af.employee.service.EmployeeService;
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
@RequestMapping("emp/employee")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping("/list")
    public List<Employee> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeVo> get(@PathVariable Long id) {
            Employee employee = service.get(id);
            return new ResponseEntity<EmployeeVo>(new EmployeeVo(employee), HttpStatus.OK);
    }

    @PostMapping("/save")
    public void save(@RequestBody Employee employee) {
        service.save(employee);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Long id) {
        try {
            Employee existProduct = service.get(id);
            service.save(employee);
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
