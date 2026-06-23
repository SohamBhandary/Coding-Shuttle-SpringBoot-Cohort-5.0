package com.Soham.Module_2_SpringBoot_MVC.Repositories;

import com.Soham.Module_2_SpringBoot_MVC.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {



}
