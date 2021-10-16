package com.af.employee.service;

import com.af.employee.entity.Employee;
import com.af.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> listAll() {
        List<Employee> employees = new ArrayList<Employee>();
        repo.findAll().forEach(emp -> employees.add(emp));
        return employees;
    }

    public void save(Employee employee) {

        repo.save(employee);
    }

    public Employee get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }


}
