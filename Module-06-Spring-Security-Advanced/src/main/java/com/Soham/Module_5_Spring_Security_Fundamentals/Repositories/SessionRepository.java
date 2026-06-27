package Repositories;

import Entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {


    List<Session> findByUser(com.Soham.Module_5_Spring_Security_Fundamentals.Entities.User user);

    Optional<Session> findByRefreshToken(String refreshToken);
}
