package com.Soham.Module_2_SpringBoot_MVC.DTOs;

import com.Soham.Module_2_SpringBoot_MVC.Annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
  private   Long id;
  @NotBlank(message = "Name cannot be empty")
  @Size(min = 2, max=40, message = "Number of character should eb within 2 and 40")
    private  String name;
  @NotBlank(message = "Email cannot be blank")
  @Email(message = "Email should be valid")
    private  String email;

  @Max(value = 90,message = "Age cannot be greater than 80")
  @Min(value = 18,message = "Age cannot be lesser than 18")
    private  Integer age;

  @NotBlank(message = "Salary cannot be blank")
  @Positive(message = "Salary should be positive")
  @Digits(integer =6,fraction = 2,message = "Salary can be in xxxxxx.xx")
  @DecimalMin(value="100.50")
  @DecimalMax(value = "1000000.00")
  private Double Salary;

  @PastOrPresent(message = "Date of join should be past or present")
  private LocalDate dateofJoin;

  @FutureOrPresent(message = "Date of switch should be in future or present")
  private LocalDate dateofSwitch;



  @NotBlank(message = "Role cannot be blank")
//  @Pattern(regexp = "^(ADMIN|USER)$",message = "Role of employee can be user or admin")
  @EmployeeRoleValidation
  private String role; //ADMIN,USER

  @AssertTrue(message = "Employees shoudl be active")
  @JsonProperty("isActive")
    private  Boolean isActive;
}
