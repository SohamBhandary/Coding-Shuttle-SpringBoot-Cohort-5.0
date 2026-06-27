package com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Repositories;

import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}