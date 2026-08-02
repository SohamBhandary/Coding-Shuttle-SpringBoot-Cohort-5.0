package com.Soham.Module_20_Webflux.service.impl;


import com.Soham.Module_20_Webflux.dto.UserRequest;
import com.Soham.Module_20_Webflux.dto.UserResponse;
import com.Soham.Module_20_Webflux.entity.User;
import com.Soham.Module_20_Webflux.error.ResourceNotFoundException;
import com.Soham.Module_20_Webflux.repository.UserRepository;
import com.Soham.Module_20_Webflux.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Mono<UserResponse> getUserById(Long id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("User", id)))
                .map(UserResponse::from);
    }

    @Override
    public Flux<UserResponse> findAll() {
        return userRepository.findAll()
                .map(UserResponse::from);
    }

    @Override
    public Mono<UserResponse> createUser(UserRequest request) {
        return userRepository.existsByEmail(request.getEmail())
                .flatMap(exists -> {
                    if (exists) return Mono.error(new IllegalArgumentException("User already exists with email: "+request.getEmail()));
                    User user = User.builder()
                            .name(request.getName())
                            .email(request.getEmail())
                            .role(request.getRole())
                            .build();
                    return userRepository.save(user);
                })
                .map(UserResponse::from)
                .doOnSuccess(u -> log.info("Created user with id: "+u.getId()));
    }
}
