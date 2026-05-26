package com.Soham.Module_2_SpringBoot_MVC.Controllers;

import com.Soham.Module_2_SpringBoot_MVC.DTOs.EmployeeDTO;
import com.Soham.Module_2_SpringBoot_MVC.Entities.EmployeeEntity;
import com.Soham.Module_2_SpringBoot_MVC.Repositories.EmployeeRepository;
import com.Soham.Module_2_SpringBoot_MVC.Services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
//    @GetMapping("/home")
//    public String testGet(){

//        return "This is our first controller";
//    }
    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id){
        return employeeService.getEmpById(id);
    }
    @GetMapping()
    public  List<EmployeeDTO> getAllEmployee(){
        return employeeService.findAllEmployee();
    }
//
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO EmployeeDTO){
        return employeeService.createNewEmployee(EmployeeDTO);
    }
//
//    @PutMapping
//    public String updateEmp(){
//        return "Update";
//    }

}
