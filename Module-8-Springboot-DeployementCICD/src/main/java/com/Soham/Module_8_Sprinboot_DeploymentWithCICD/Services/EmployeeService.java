package com.Soham.Module_8_Sprinboot_DeploymentWithCICD.Services;


import com.Soham.Module_8_Sprinboot_DeploymentWithCICD.Dtos.EmployeeDto;

public interface EmployeeService {

    EmployeeDto getEmployeeById(Long id);
    EmployeeDto createNewEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
    void deleteEmployee(Long id);
}
