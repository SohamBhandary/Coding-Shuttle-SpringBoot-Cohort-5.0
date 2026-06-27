package com.Soham.Module_7_Springboot_Testing.Controllers;

import com.Soham.Module_7_Springboot_Testing.Dtos.EmployeeDto;
import com.Soham.Module_7_Springboot_Testing.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

public class AbstractIntegrationTestClass {
    @Autowired
    WebTestClient webTestClient;

    Employee testEmployee = Employee.builder()
            .id(1L)
            .email("anuj@gmail.com")
            .name("Anuj")
            .salary(200L)
            .build();
    EmployeeDto testEmployeeDto = EmployeeDto.builder()
            .id(1L)
            .email("anuj@gmail.com")
            .name("Anuj")
            .salary(200L)
            .build();
}
