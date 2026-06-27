package com.Soham.Module_2_SpringBoot_MVC.Controllers;

import com.Soham.Module_2_SpringBoot_MVC.DTOs.EmployeeDTO;
import com.Soham.Module_2_SpringBoot_MVC.Entities.EmployeeEntity;
import com.Soham.Module_2_SpringBoot_MVC.Exceptions.ResourceNotFoundException;
import com.Soham.Module_2_SpringBoot_MVC.Repositories.EmployeeRepository;
import com.Soham.Module_2_SpringBoot_MVC.Services.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id){
       Optional  <EmployeeDTO> emp= employeeService.getEmpById(id);
     return emp.map(emp1->ResponseEntity.ok(emp1)).orElseThrow(()-> new ResourceNotFoundException("Not found"+id));
    }
    @GetMapping()
    public ResponseEntity <List<EmployeeDTO>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.findAllEmployee());
    }
//
    @PostMapping
    public ResponseEntity <EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO EmployeeDTO){
        EmployeeDTO saved= employeeService.createNewEmployee(EmployeeDTO);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
//
    @PutMapping("/{id}")
    public  ResponseEntity <EmployeeDTO> updateEmpById(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long id){
        return ResponseEntity.ok(employeeService.updateEmpById(employeeDTO,id));
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id ){
        employeeService.deleteByid(id);
    }
    @PatchMapping("/{id}")
    public EmployeeDTO updatePartialEmployeeId(@RequestBody Map<String,Object> updates,
                                               @PathVariable Long id){
        return employeeService.updatePartialEmployeeId(updates,id);
    }


}
