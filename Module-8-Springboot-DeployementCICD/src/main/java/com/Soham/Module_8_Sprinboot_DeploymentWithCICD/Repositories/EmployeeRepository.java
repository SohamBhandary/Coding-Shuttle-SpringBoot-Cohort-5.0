package com.Soham.Module_8_Sprinboot_DeploymentWithCICD.Repositories;


import com.Soham.Module_8_Sprinboot_DeploymentWithCICD.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmail(String email);
}
