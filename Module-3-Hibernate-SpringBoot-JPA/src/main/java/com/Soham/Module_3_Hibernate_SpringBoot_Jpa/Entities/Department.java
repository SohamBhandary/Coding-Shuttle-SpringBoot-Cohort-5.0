package com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.Doc;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length =100)
    private String name;

    @OneToOne
    @JoinColumn(nullable = false)
    private Doctor headDoctor;


    @ManyToMany
    private Set<Doctor> doctors= new HashSet<>();






}
