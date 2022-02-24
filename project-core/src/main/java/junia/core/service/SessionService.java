package junia.core.service;

import junia.core.dao.SessionDAO;
import junia.core.entity.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SessionService {
    private final  SessionDAO sessionDAO;

    public SessionService(SessionDAO sessionDAO) {
        this.sessionDAO = sessionDAO;
    }

    public void deleteAll() {
        sessionDAO.deleteAll();
    }

    public void save(final Session session) {
        sessionDAO.save(session);
    }

    public List<Session> findAllSessionsSpecificArcade(String arcadeName){
        return sessionDAO.findAllSessionsSpecificArcade(arcadeName);
    }
}
