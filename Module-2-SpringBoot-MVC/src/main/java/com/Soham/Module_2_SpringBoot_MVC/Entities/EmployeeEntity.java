package com.Soham.Module_2_SpringBoot_MVC.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="Employees")
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private   Long id;
    private  String name;
    private  String email;
    private String role;
    private  Integer age;
    private Double Salary;
    private LocalDate dateofJoin;
    private LocalDate dateofSwitch;
    @JsonProperty("isActive")
    private  Boolean isActive;
}
