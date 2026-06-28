package com.Soham.Module_11_Caching_Concurrent_Transactions.services;


import com.Soham.Module_11_Caching_Concurrent_Transactions.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto getEmployeeById(Long id);
    EmployeeDto createNewEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
    void deleteEmployee(Long id);
}
