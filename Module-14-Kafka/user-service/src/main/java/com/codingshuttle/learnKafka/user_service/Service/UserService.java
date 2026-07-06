package com.codingshuttle.learnKafka.user_service.Service;



import com.codingshuttle.learnKafka.user_service.Repository.UserRepository;
import com.codingshuttle.learnKafka.user_service.DTO.CreateUserRequestDto;
import com.codingshuttle.learnKafka.user_service.Entitity.User;
import com.codingshuttle.learnKafka.user_service.Event.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Value("${kafka.topic.user-created-topic}")
    private String KAFKA_USER_CREATED_TOPIC;

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final KafkaTemplate<Long, UserCreatedEvent> kafkaTemplate;


    public void createUser(CreateUserRequestDto createUserRequestDto) {

        User user = modelMapper.map(createUserRequestDto, User.class);
        User savedUser = userRepository.save(user);
         UserCreatedEvent userCreatedEvent=modelMapper.map(savedUser, UserCreatedEvent.class);
         kafkaTemplate.send(KAFKA_USER_CREATED_TOPIC,userCreatedEvent.getId(),userCreatedEvent);







    }

}
