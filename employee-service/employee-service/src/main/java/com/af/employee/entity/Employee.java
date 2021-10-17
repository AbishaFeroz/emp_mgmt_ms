package com.af.employee.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    Long id;
    String name;
    String address;
    String password;
    String mail;
    String phoneNumber;
    String code;
    Date joiningDate;

    int yearsOfExperience;
    @OneToOne
    @JoinColumn(name = "designation_id", referencedColumnName = "id")
    Designation designation;

}
