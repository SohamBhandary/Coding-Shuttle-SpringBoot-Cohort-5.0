package com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(length = 100)
    private String specialaiztion;

    @Column(nullable = false,unique = true,length = 100)
    private String email;


    @OneToMany(mappedBy = "doctor" )
    private Set<Appoinment> appoinmentSet= new HashSet<>();
}
