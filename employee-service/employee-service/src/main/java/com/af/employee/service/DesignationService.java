package com.af.employee.service;

import com.af.employee.entity.Designation;
import com.af.employee.entity.Employee;
import com.af.employee.repository.DesignationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DesignationService {

    @Autowired
    private DesignationRepository repo;
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public void save(Designation designation) {
        repo.save(designation);
    }

    public Designation get(Long id) {
        return repo.findById(id).get();
    }

    public List<Designation> list() {
        List<Designation> designations = new ArrayList<Designation>();
        repo.findAll().forEach(obj -> designations.add(obj));
        return designations;
    }
}
