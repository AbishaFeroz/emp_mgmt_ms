package com.af.employee.service;

import com.af.employee.entity.Designation;
import com.af.employee.entity.Training;
import com.af.employee.repository.DesignationRepository;
import com.af.employee.repository.TrainingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TrainingService {

    @Autowired
    private TrainingRepository repo;
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public void save(Training training) {
        repo.save(training);
    }

    public Training get(Long id) {
        return repo.findById(id).get();
    }

    public List<Training> list() {
        List<Training> trainings = new ArrayList<Training>();
        repo.findAll().forEach(obj -> trainings.add(obj));
        return trainings;
    }
}
