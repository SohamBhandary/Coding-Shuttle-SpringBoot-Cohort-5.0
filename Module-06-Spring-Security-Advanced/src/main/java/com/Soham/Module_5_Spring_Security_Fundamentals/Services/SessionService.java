package Services;

import Entities.Session;
import Repositories.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;
    private final int SESSION_LIMIT=2;

    public void generateNewSession(com.Soham.Module_5_Spring_Security_Fundamentals.Entities.User user, String refreshToken){

        List<Session> userSessions=sessionRepository.findByUser(user);
        if(userSessions.size()==SESSION_LIMIT){
            userSessions.sort(Comparator.comparing(Session::getLastUsedAt));
            Session lastRecentSession=userSessions.getFirst(); // we deleet the first seesios to make safe to create new seesion
            sessionRepository.delete(lastRecentSession);

        }
        Session newSession=Session.builder().user(user).refreshToken(refreshToken).build();
        sessionRepository.save(newSession);

    }

    public void validateSession(String refreshToken){
     Session session=    sessionRepository.findByRefreshToken(refreshToken).orElseThrow(()-> new SessionAuthenticationException("Session not found"+refreshToken));
     session.setLastUsedAt(LocalDateTime.now());
     sessionRepository.save(session);

    }
}
