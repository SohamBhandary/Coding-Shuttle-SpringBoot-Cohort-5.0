package com.Soham.Module_5_Spring_Security_Fundamentals.DTOs;

import com.Soham.Module_5_Spring_Security_Fundamentals.Entities.enums.Permission;
import com.Soham.Module_5_Spring_Security_Fundamentals.Entities.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpDTO {
    private String email;
    private String password;
    private String name;
    private Set<Role> roles;
    private Set<Permission> permissions;
}
