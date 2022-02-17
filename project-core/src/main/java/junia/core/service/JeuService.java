package junia.core.service;

import junia.core.dao.JeuDAO;
import junia.core.entity.Jeu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JeuService {

    private JeuDAO jeuDAO;

    public JeuService(JeuDAO jeuDAO) {
        this.jeuDAO = jeuDAO;
    }

    public void deleteAll() {
        jeuDAO.deleteAll();
    }

    public void save(final Jeu jeu) {
        jeuDAO.save(jeu);
    }

    public Jeu findJeu(long id){
        return jeuDAO.findJeu(id);
    }

    public Jeu findFilmByName(String arcadeName){
        return jeuDAO.findJeuByName(arcadeName);
    }
}