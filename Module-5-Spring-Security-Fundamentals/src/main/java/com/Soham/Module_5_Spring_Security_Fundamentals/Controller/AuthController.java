package com.Soham.Module_5_Spring_Security_Fundamentals.Controller;

import com.Soham.Module_5_Spring_Security_Fundamentals.DTOs.LoginDTO;
import com.Soham.Module_5_Spring_Security_Fundamentals.DTOs.SignUpDTO;
import com.Soham.Module_5_Spring_Security_Fundamentals.DTOs.UserDTO;
import com.Soham.Module_5_Spring_Security_Fundamentals.Services.AuthService;
import com.Soham.Module_5_Spring_Security_Fundamentals.Services.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
        String token=authService.login(loginDTO);
        return ResponseEntity.ok(token);
    }


}
