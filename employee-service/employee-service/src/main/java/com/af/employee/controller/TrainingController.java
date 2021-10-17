package com.af.employee.controller;

import com.af.employee.entity.Designation;
import com.af.employee.entity.Training;
import com.af.employee.service.DesignationService;
import com.af.employee.service.TrainingService;
import com.af.employee.vo.DesignationVo;
import com.af.employee.vo.TrainingVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Slf4j
@RequestMapping("emp/training")
public class TrainingController {

    @Autowired
    TrainingService service;

    @GetMapping("/list")
    public List<Training> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingVo> get(@PathVariable Long id) {
        Training training = service.get(id);
        return new ResponseEntity<TrainingVo>(new TrainingVo(training), HttpStatus.OK);
    }


    @PostMapping("/save")
    public void save(@RequestBody Training training) {

        service.save(training);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
