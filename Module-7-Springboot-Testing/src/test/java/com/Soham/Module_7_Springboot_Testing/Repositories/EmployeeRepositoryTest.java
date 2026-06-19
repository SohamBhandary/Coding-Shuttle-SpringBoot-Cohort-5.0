package com.Soham.Module_7_Springboot_Testing.Repositories;

import com.Soham.Module_7_Springboot_Testing.Entities.Employee;
import com.Soham.Module_7_Springboot_Testing.TestContainerConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestContainerConfiguration.class)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .name("Soham")
                .email("soham@gmail.com")
                .salary(100L)
                .build();
    }

    @Test
    void testFindByEmailWhenEmailIsValid_thenReturnEmployee() {
        // Given
        employeeRepository.save(employee);

        // When
        List<Employee> employeeList =
                employeeRepository.findByEmail(employee.getEmail());

        // Then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isNotEmpty();
        assertThat(employeeList.get(0).getEmail()).isEqualTo(employee.getEmail());
    }

    @Test
    void testFindByEmailWhenEmailIsNotFound_thenReturnEmptyEmployee() {
        // When

        String email = "notPresent.123@gmail.com";
//        When
        List<Employee> employeeList = employeeRepository.findByEmail(email);
//        Then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isEmpty();
    }
}