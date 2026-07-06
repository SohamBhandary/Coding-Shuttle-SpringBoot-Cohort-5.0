package com.codingshuttle.learnKafka.user_service.Event;

import lombok.Data;

@Data
public class UserCreatedEvent {
    private Long id;

    private String email;
}
