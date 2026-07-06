package com.codingshuttle.learnKafka.user_service.DTO;

import lombok.Data;

@Data
public class CreateUserRequestDto {

    private Long id;
    private String name;
    private String email;
}