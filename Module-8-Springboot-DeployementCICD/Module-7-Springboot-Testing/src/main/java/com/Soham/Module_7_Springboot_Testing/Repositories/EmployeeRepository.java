package com.Soham.Module_7_Springboot_Testing.Repositories;

import com.Soham.Module_7_Springboot_Testing.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmail(String email);
}
