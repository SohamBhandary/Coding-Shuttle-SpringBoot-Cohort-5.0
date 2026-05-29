package com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities;

import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities.types.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String birthDate;
    private String email;
    private String gender;

    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodGroupType;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(cascade = {CascadeType.ALL    })
    @JoinColumn(name = "patient_insurance")
    private Insurance insurance; //owning

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL) //inverse side(mapped by)
    private Set<Appoinment> appoinments= new HashSet<>();

}
