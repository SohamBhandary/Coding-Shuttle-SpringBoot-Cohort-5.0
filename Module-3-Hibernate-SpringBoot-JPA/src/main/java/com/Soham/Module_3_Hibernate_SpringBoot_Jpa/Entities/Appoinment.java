package com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appoinment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY) //owning side
    @JoinColumn(nullable = false)
    private Patient patient;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Set<Doctor> doctor;
}
