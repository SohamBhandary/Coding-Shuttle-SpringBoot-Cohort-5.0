package com.Soham.Module_5_Spring_Security_Fundamentals.Controller;

import com.Soham.Module_5_Spring_Security_Fundamentals.DTOs.LoginDTO;
import com.Soham.Module_5_Spring_Security_Fundamentals.DTOs.LoginResponseDTO;
import com.Soham.Module_5_Spring_Security_Fundamentals.DTOs.SignUpDTO;
import com.Soham.Module_5_Spring_Security_Fundamentals.DTOs.UserDTO;
import com.Soham.Module_5_Spring_Security_Fundamentals.Services.AuthService;
import com.Soham.Module_5_Spring_Security_Fundamentals.Services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;




    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signup(@RequestBody SignUpDTO signUpDTO){
        UserDTO userDTO=userService.signup(signUpDTO);
        return ResponseEntity.ok(userDTO);

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO, HttpServletRequest req,
                                        HttpServletResponse response){
        LoginResponseDTO loginResponseDTO =authService.login(loginDTO);
        Cookie cookie= new Cookie("refreshToken",loginResponseDTO.getRefreshToken());
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        response.addCookie(cookie);
        return ResponseEntity.ok(loginResponseDTO);
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponseDTO> refresh(HttpServletRequest request){
     String refreshToken=   Arrays.stream(request.getCookies()).filter(cookie->"refreshToken".equals(cookie.getName()))
                .findFirst()
             .map(Cookie::getValue)
                .orElseThrow(()-> new AuthenticationServiceException("Refresh Token Not found"));


        LoginResponseDTO loginResponseDTO = authService.refreshToken(refreshToken);
        return ResponseEntity.ok(loginResponseDTO);
    }


}
