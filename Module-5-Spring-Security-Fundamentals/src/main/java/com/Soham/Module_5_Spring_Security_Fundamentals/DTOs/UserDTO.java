package com.Soham.Module_5_Spring_Security_Fundamentals.DTOs;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String password;
    private String name;

}
