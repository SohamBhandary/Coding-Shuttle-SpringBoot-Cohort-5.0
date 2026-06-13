package com.Soham.Module_5_Spring_Security_Fundamentals.Services;

import com.Soham.Module_5_Spring_Security_Fundamentals.DTOs.LoginDTO;
import com.Soham.Module_5_Spring_Security_Fundamentals.DTOs.LoginResponseDTO;
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
    private final UserService userService;

    public LoginResponseDTO login(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        String accessToken = jwtSerivce.generateAccessToken(user);
        String refreshToken = jwtSerivce.generateRefreshToken(user);
        return new LoginResponseDTO(user.getId(), accessToken, refreshToken);
    }

    public LoginResponseDTO refreshToken(String refreshToken) {

        Long userId = jwtSerivce.getUserIdFromToken(refreshToken);

        User user = userService.getUseryId(userId);

        String accessToken = jwtSerivce.generateAccessToken(user);
        return new LoginResponseDTO(user.getId(), accessToken, refreshToken);

    }
}
