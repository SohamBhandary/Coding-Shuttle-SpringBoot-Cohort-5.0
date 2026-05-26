package com.Soham.Module_2_SpringBoot_MVC.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
  private   Long id;
    private  String name;
    private  String email;
    private  Integer age;
  @JsonProperty("isActive")
    private  Boolean isActive;
}
