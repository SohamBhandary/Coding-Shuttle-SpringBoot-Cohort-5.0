package com.Soham.Module_2_SpringBoot_MVC.Controllers;

import com.Soham.Module_2_SpringBoot_MVC.DTOs.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
//    @GetMapping("/home")
//    public String testGet(){
//        return "This is our first controller";
//    }
    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id){
        return new EmployeeDTO(id,"soham","@gmail",22,true);
    }
    @GetMapping()
    public String getEmployee(@RequestParam Integer age){
        return "Hi age" + age;
    }

    @PostMapping
    public String createNewEmployee(){
        return "Hello";
    }

    @PutMapping
    public String updateEmp(){
        return "Update";
    }

}
