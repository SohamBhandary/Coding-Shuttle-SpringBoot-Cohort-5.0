package com.Soham.Module_5_Spring_Security_Fundamentals.Services;

import com.Soham.Module_5_Spring_Security_Fundamentals.DTOs.LoginDTO;
import com.Soham.Module_5_Spring_Security_Fundamentals.DTOs.SignUpDTO;
import com.Soham.Module_5_Spring_Security_Fundamentals.DTOs.UserDTO;
import com.Soham.Module_5_Spring_Security_Fundamentals.Entities.User;
import com.Soham.Module_5_Spring_Security_Fundamentals.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
//    private final AuthenticationManager authenticationManager;
//    private final JWTSerivce jwtSerivce;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow();
    }

    public UserDTO signup(SignUpDTO signUpDTO) {
      Optional<User> user= userRepository.findByEmail(signUpDTO.getEmail());
      if(user.isPresent()){
          throw new BadCredentialsException("User already exists");
      }

      User toCreate=modelMapper.map(signUpDTO,User.class);
      toCreate.setPassword(passwordEncoder.encode(toCreate.getPassword()));
      User tosave=userRepository.save(toCreate);

      return modelMapper.map(tosave,UserDTO.class);



    }


}
