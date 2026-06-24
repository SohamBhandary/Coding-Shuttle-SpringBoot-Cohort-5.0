package com.Soham.Module_5_Spring_Security_Fundamentals.Services;

import com.Soham.Module_5_Spring_Security_Fundamentals.DTOs.LoginDTO;
import com.Soham.Module_5_Spring_Security_Fundamentals.Entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTSerivce jwtSerivce;

    public String login(LoginDTO loginDTO) {
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),loginDTO.getPassword())
        );
        User user1=(User) authentication.getPrincipal();
        return jwtSerivce.generateToken(user1);
    }
}
