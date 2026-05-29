package com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Repositories;

import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities.Appoinment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppoinmentRepository extends JpaRepository<Appoinment, Long> {
}