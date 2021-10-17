package com.af.employee.repository;

import com.af.employee.entity.SkillCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillCategoryRepository  extends JpaRepository<SkillCategory, Long> {
}
