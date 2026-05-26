package com.Soham.Module_2_SpringBoot_MVC.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Employees")
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private   Long id;
    private  String name;
    private  String email;
    private  Integer age;
    @JsonProperty("isActive")
    private  Boolean isActive;
}
