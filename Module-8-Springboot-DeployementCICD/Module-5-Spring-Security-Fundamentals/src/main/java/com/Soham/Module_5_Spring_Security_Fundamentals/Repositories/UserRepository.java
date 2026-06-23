package com.Soham.Module_5_Spring_Security_Fundamentals.Repositories;

import com.Soham.Module_5_Spring_Security_Fundamentals.Entities.User;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
