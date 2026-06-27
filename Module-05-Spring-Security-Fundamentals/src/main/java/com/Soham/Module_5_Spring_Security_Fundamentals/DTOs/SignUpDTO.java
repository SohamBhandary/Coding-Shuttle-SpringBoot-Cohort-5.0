package com.Soham.Module_5_Spring_Security_Fundamentals.DTOs;

import lombok.Data;

@Data
public class SignUpDTO {
    private String email;
    private String password;
    private String name;
}
