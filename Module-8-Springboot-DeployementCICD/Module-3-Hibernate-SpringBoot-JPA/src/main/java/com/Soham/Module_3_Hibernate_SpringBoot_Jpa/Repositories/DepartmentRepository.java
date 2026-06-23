package com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Repositories;

import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}