package com.Soham.Module_2_SpringBoot_MVC.Controllers;

import com.Soham.Module_2_SpringBoot_MVC.DTOs.EmployeeDTO;
import com.Soham.Module_2_SpringBoot_MVC.Entities.EmployeeEntity;
import com.Soham.Module_2_SpringBoot_MVC.Repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
//    @GetMapping("/home")
//    public String testGet(){
//        return "This is our first controller";
//    }
    @GetMapping("/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Long id){
        return employeeRepository.findById(id).orElseThrow();
    }
    @GetMapping()
    public  List<EmployeeEntity> getAllEmployee(){
        return employeeRepository.findAll();
    }
//
    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);
    }
//
//    @PutMapping
//    public String updateEmp(){
//        return "Update";
//    }

}
