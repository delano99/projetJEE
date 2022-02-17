package junia.core.service;

import junia.core.dao.ArcadeDAO;
import junia.core.entity.Arcade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArcadeService {

    private ArcadeDAO arcadeDAO;

    public ArcadeService(ArcadeDAO arcadeDAO) {
        this.arcadeDAO = arcadeDAO;
    }

    public void deleteAll() {
        arcadeDAO.deleteAll();
    }
    public void save(final Arcade arcade){
        arcadeDAO.save(arcade);
    }
    public List<Arcade> findAll(){
        return arcadeDAO.findAll();
    }
}
