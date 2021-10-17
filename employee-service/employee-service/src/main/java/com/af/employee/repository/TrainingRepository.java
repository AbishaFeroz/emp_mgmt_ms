package com.af.employee.repository;

import com.af.employee.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository  extends JpaRepository<Training, Long> {
}
