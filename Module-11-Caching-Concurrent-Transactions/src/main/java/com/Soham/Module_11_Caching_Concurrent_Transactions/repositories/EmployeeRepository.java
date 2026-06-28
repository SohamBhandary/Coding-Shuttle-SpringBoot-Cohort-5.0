package com.Soham.Module_11_Caching_Concurrent_Transactions.repositories;

import com.Soham.Module_11_Caching_Concurrent_Transactions.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmail(String email);
}
