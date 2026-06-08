package com.Soham.Module_5_Spring_Security_Fundamentals.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(auth->
                auth.requestMatchers("/posts","/error","/auth/**").permitAll()
                        .requestMatchers("/posts/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated())
                .csrf(config->config.disable())
                .sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))


        ;

        return httpSecurity.build();



    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)throws Exception{
        return configuration.getAuthenticationManager();
    }

//    @Bean

//    UserDetailsService inMemory(){
//        UserDetails normal= User.withUsername("Soham").password(passwordEncoder().encode("0000"))
//                .roles("USER").build();
//        UserDetails admin= User.withUsername("Admin").password(passwordEncoder().encode("0000"))
//                .roles("ADMIN").build();
//
//        return new InMemoryUserDetailsManager(normal,admin);
//    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
