package com.Soham.Module_20_Webflux.service;


import com.Soham.Module_20_Webflux.dto.UserRequest;
import com.Soham.Module_20_Webflux.dto.UserResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserResponse> getUserById(Long id);

    Flux<UserResponse> findAll();

    Mono<UserResponse> createUser(UserRequest request);
}
