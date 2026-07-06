package com.codingshuttle.learnKafka.user_service.Repository;


import com.codingshuttle.learnKafka.user_service.Entitity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
