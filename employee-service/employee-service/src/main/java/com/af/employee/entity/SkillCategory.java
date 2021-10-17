package com.af.employee.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillCategory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("_id")
    Long id;
    String name;

}